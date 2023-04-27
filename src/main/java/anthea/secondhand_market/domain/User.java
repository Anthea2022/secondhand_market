package anthea.secondhand_market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author anthea
 * @date 2023/4/20 23:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 学号
     */
    private Long stuId;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 性别
     */
    private String gender;

    /**
     * 余额
     */
    private int balance;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
