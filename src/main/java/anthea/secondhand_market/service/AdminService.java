package anthea.secondhand_market.service;

import anthea.secondhand_market.util.BaseResponse;

/**
 * @author anthea
 * @date 2023/6/6 11:00
 */
public interface AdminService {
    BaseResponse<Object> login(String name, String password);

    BaseResponse<Object> deleteUser(Long userId);

    BaseResponse<Object> selectByUserId(Long userId);
}
