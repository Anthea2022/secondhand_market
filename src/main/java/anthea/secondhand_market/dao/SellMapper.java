package anthea.secondhand_market.dao;

import anthea.secondhand_market.domain.Sell;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author anthea
 * @date 2023/4/25 9:19
 */
public interface SellMapper extends BaseMapper<Sell> {
    Sell queryByGoodsId(Long goodsId);

    List<Sell> queryByUserId(Long userId);
}
