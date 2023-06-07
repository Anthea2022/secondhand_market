package anthea.secondhand_market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anthea
 * @date 2023/6/6 10:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Long id;

    private String msg;

    private Long userFrom;

    private Long userTo;
}
