package anthea.secondhand_market.dao;

import anthea.secondhand_market.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author anthea
 * @date 2023/4/25 9:15
 */
public interface UserMapper extends BaseMapper<User> {
    User verifyPassword(User user);

    void income(Long userId, int money);

    void costMoney(Long userId, int money);

    void addUser(String name, String password, String phone, String gender, int balance, Long stuId);
}
