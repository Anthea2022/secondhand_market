package anthea.secondhand_market.service.impl;

import anthea.secondhand_market.config.exceptions.BusinessException;
import anthea.secondhand_market.constant.enums.ResponseCodes;
import anthea.secondhand_market.dao.*;
import anthea.secondhand_market.domain.Admin;
import anthea.secondhand_market.domain.User;
import anthea.secondhand_market.service.AdminService;
import anthea.secondhand_market.util.BaseResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author anthea
 * @date 2023/6/6 11:08
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private SellMapper sellMapper;

    @Resource
    private BuyMapper buyMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public BaseResponse<Object> login(String name, String password) {
        Admin admin = adminMapper.verifyByPassword(name, password);
        if (ObjectUtils.isEmpty(admin)) {
            throw new BusinessException(ResponseCodes.QUERY_NULL_ERROR, "账号或密码错误");
        }
        return BaseResponse.success(admin);
    }

    @Override
    public BaseResponse<Object> deleteUser(Long userId) {
        if (ObjectUtils.isEmpty(userMapper.queryById(userId))) {
            throw new BusinessException(ResponseCodes.QUERY_NULL_ERROR, "无该用户");
        }
        goodsMapper.deleteByUserId(userId);
        sellMapper.deleteByUserId(userId);
        buyMapper.deleteByUserId(userId);
        userMapper.deleteUser(userId);
        return BaseResponse.success("删除成功");
    }

    @Override
    public BaseResponse<Object> selectByUserId(Long userId) {
        if (ObjectUtils.isEmpty(userMapper.queryById(userId))) {
            return BaseResponse.success("无该用户");
        }
        return BaseResponse.success(userMapper.queryById(userId));
    }
}
