package anthea.secondhand_market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author anthea
 * @date 2023/4/24 23:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buy implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 买家
     */
    private Long buyerId;

    /**
     * 货物
     */
    private Long goodsId;

    /**
     * 数量
     */
    private int num;

    /**
     * 创建时间
     */
    private Date createTime;

    public Buy(Long buyerId, Long goodsId, int num) {
        this.buyerId = buyerId;
        this.goodsId = goodsId;
        this.num = num;
    }
}
