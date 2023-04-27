package anthea.secondhand_market.dao;

import anthea.secondhand_market.domain.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author anthea
 * @date 2023/4/25 9:18
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    List<Goods> listAllGoods();

    List<Goods> getGoodsLikeName(String name);

    Goods getId(Goods goods);

    void goodsBuy(Long goodsId, int num);
}
