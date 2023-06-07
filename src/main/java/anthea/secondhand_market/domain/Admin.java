package anthea.secondhand_market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anthea
 * @date 2023/6/6 10:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long id;

    private String name;

    private String password;
}
