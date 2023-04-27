package anthea.secondhand_market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author anthea
 * @date 2023/4/24 23:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sell implements Serializable {
    private static  final Long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 卖家
     */
    private Long sellerId;

    /**
     * 货物
     */
    private Long goodsId;

    public Sell(Long sellerId, Long goodsId) {
        this.sellerId = sellerId;
        this.goodsId = goodsId;
    }
}
