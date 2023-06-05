package anthea.secondhand_market.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author anthea
 * @date 2023/4/24 23:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    private static final Long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 货物名字
     */
    private String name;

    /**
     * 货物描述
     */
    private String refer;

    /**
     * 数量
     */
    private int num;

    /**
     * 价格
     */
    private int price;

    /**
     * 图片
     */
    private String img;
}
