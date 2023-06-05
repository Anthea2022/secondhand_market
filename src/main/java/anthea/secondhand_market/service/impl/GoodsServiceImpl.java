package anthea.secondhand_market.service.impl;

import anthea.secondhand_market.config.exceptions.BusinessException;
import anthea.secondhand_market.constant.enums.ResponseCodes;
import anthea.secondhand_market.dao.BuyMapper;
import anthea.secondhand_market.dao.GoodsMapper;
import anthea.secondhand_market.dao.SellMapper;
import anthea.secondhand_market.dao.UserMapper;
import anthea.secondhand_market.domain.Buy;
import anthea.secondhand_market.domain.Goods;
import anthea.secondhand_market.domain.Sell;
import anthea.secondhand_market.service.GoodsService;
import anthea.secondhand_market.util.BaseResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anthea
 * @date 2023/4/25 9:26
 */
@Service
@Transactional
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
       implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Resource
    BuyMapper buyMapper;

    @Resource
    SellMapper sellMapper;

    @Resource
    UserMapper userMapper;

    @Override
    public BaseResponse<Object> listGoods() {
        List<Goods> goodsList = goodsMapper.listAllGoods();
        return BaseResponse.success(goodsList);
    }

    @Override
    public BaseResponse<Object> getGoodsLikeName(String name) {
        List<Goods> goodsLikeName = goodsMapper.getGoodsLikeName(name);
        return BaseResponse.success(goodsLikeName);
    }

    @Override
    public BaseResponse<Object> getUserGoods(Long userId) {
        List<Goods> goodsList = goodsMapper.queryByBuyerId(userId);
        return BaseResponse.success(goodsList);
    }

    @Override
    public BaseResponse<Object> getUserSell(Long userId) {
        if (ObjectUtils.isEmpty(userMapper.selectById(userId))) {
            throw new BusinessException(ResponseCodes.QUERY_NULL_ERROR, "无此用户");
        }
        List<Goods> goodsList = goodsMapper.queryBySellerId(userId);
        return BaseResponse.success(goodsList);
    }
}
