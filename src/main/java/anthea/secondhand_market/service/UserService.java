package anthea.secondhand_market.service;

import anthea.secondhand_market.domain.Goods;
import anthea.secondhand_market.domain.User;
import anthea.secondhand_market.util.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anthea
 * @date 2023/4/25 9:20
 */
public interface UserService extends IService<User> {
    @Transactional
    BaseResponse<Object> login(String name, String password);

    @Transactional
    BaseResponse<Object> income(Long userId, int money);

    @Transactional
    BaseResponse<Object> save(Long userId, int money);

    @Transactional
    BaseResponse<Object> cost(Long userId, int money);

    @Transactional
    BaseResponse<Object> getUserDataById(Long userId);

    @Transactional
    BaseResponse<Object> addGoods(Long userId, Goods goods);

    @Transactional
    BaseResponse<Object> buy(Long userId, Long goodsId, int num);

    @Transactional
    BaseResponse<Object> addUser(User user);

    @Transactional
    BaseResponse<Object> setPassword(User user);
}
