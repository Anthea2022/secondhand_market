package anthea.secondhand_market.service.impl;

import anthea.secondhand_market.config.exceptions.BusinessException;
import anthea.secondhand_market.constant.consts.RedisConstant;
import anthea.secondhand_market.constant.enums.ResponseCodes;
import anthea.secondhand_market.dao.BuyMapper;
import anthea.secondhand_market.dao.GoodsMapper;
import anthea.secondhand_market.dao.SellMapper;
import anthea.secondhand_market.dao.UserMapper;
import anthea.secondhand_market.domain.Buy;
import anthea.secondhand_market.domain.Goods;
import anthea.secondhand_market.domain.Sell;
import anthea.secondhand_market.domain.User;
import anthea.secondhand_market.service.UserService;
import anthea.secondhand_market.util.BaseResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author anthea
 * @date 2023/4/25 9:23
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
       implements UserService {
    @Resource
    UserMapper userMapper;

    @Resource
    SellMapper sellMapper;

    @Resource
    BuyMapper buyMapper;

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Override
    public BaseResponse<Object> login(String name, String password) {
        User user = new User(name, password);
        if (ObjectUtils.isEmpty(userMapper.verifyPassword(user))) {
            throw new BusinessException(ResponseCodes.FAIL, "无此用户");
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse<Object> income(Long userId, int money) {
        userMapper.income(userId, money);
        return BaseResponse.success("充值成功");
    }

    @Override
    public BaseResponse<Object> save(Long userId, int money) {
        userMapper.income(userId, money);
        return BaseResponse.success("存入成功");
    }

    @Override
    public BaseResponse<Object> cost(Long userId, int money) {
        int balance = userMapper.selectById(userId).getBalance();
        if (money > balance) {
            throw new BusinessException(ResponseCodes.FAIL, "余额不足");
        }
        userMapper.costMoney(userId, money);
        return BaseResponse.success("支付成功");
    }

    @Override
    public BaseResponse<Object> getUserDataById(Long userId) {
        User user = userMapper.selectById(userId);
        return BaseResponse.success(user);
    }

    @Override
    public BaseResponse<Object> addGoods(Long userId, Goods goods) {
        goodsMapper.insert(goods);
        Long goodsId = goodsMapper.getId(goods).getId();
        Sell sell = new Sell();
        sell.setSellerId(userId);
        sell.setGoodsId(goodsId);
        sellMapper.insert(sell);
        return BaseResponse.success("添加成功");
    }

    @Override
    public BaseResponse<Object> buy(Long userId, Long goodsId, int num) {
        if (ObjectUtils.isEmpty(userMapper.selectById(userId))) {
            throw new BusinessException(ResponseCodes.QUERY_NULL_ERROR, "无该用户");
        }
        if (ObjectUtils.isEmpty(goodsMapper.selectById(goodsId))) {
            throw new BusinessException(ResponseCodes.QUERY_NULL_ERROR, "无该商品");
        }
        int restNum = goodsMapper.selectById(goodsId).getNum();
        if (restNum < num) {
            throw new BusinessException(ResponseCodes.FAIL, "数量不足");
        }
        if (userMapper.selectById(userId).getBalance() < goodsMapper.selectById(goodsId).getPrice()) {
            throw new BusinessException(ResponseCodes.FAIL, "余额不足");
        }
        String tryLock = RedisConstant.REDIS_LOCK + goodsId;
        try {
            Boolean absent = stringRedisTemplate.opsForValue().setIfAbsent(tryLock, "1", RedisConstant.LOCK_GOODS_LAST_TIME, TimeUnit.SECONDS);

            // 获取锁失败
            if (BooleanUtils.isFalse(absent)) {
                Thread.sleep(200);
                buy(userId, goodsId, num);
            }

            // 获取锁成功
            Buy buy = new Buy(userId, goodsId, num);
            // 添加买家和商品的信息
            buyMapper.insert(buy);
            // 数据库中减少库存
            goodsMapper.goodsBuy(goodsId, num);
            int price = goodsMapper.selectById(goodsId).getPrice();
            // 买家付钱
            userMapper.costMoney(userId, price);
            // 卖家得钱
            userMapper.income(userId, price);
        } catch (Exception e) {
            throw new BusinessException(ResponseCodes.SYSTEM_ERROR);
        } finally {
            stringRedisTemplate.delete(tryLock);
        }
        return BaseResponse.success("购买成功");
    }
}
