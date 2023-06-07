package anthea.secondhand_market.dao;

import anthea.secondhand_market.domain.Buy;
import anthea.secondhand_market.domain.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author anthea
 * @date 2023/4/25 9:19
 */
public interface BuyMapper extends BaseMapper<Buy> {
    List<Buy> queryByUserId(Long userId);

    void deleteByUserId(Long userId);
}
