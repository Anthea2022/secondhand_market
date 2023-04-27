package anthea.secondhand_market.service;

import anthea.secondhand_market.domain.Goods;
import anthea.secondhand_market.domain.User;
import anthea.secondhand_market.util.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author anthea
 * @date 2023/4/25 9:20
 */
public interface UserService extends IService<User> {
    BaseResponse<Object> login(String name, String password);

    BaseResponse<Object> income(Long userId, int money);

    BaseResponse<Object> save(Long userId, int money);

    BaseResponse<Object> cost(Long userId, int money);

    BaseResponse<Object> getUserDataById(Long userId);

    BaseResponse<Object> addGoods(Long userId, Goods goods);

    BaseResponse<Object> buy(Long userId, Long goodsId, int num);
}
