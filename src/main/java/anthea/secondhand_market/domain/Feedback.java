package anthea.secondhand_market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anthea
 * @date 2023/6/6 11:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    private Long id;

    private Long adminId;

    private Long userId;

    private String msg;
}
