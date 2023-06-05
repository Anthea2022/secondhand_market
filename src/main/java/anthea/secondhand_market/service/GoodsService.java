package anthea.secondhand_market.service;

import anthea.secondhand_market.domain.Goods;
import anthea.secondhand_market.util.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anthea
 * @date 2023/4/25 9:21
 */
public interface GoodsService extends IService<Goods> {
    @Transactional
    BaseResponse<Object> listGoods();

    @Transactional
    BaseResponse<Object> getGoodsLikeName(String name);

    @Transactional
    BaseResponse<Object> getUserGoods(Long userId);

    @Transactional
    BaseResponse<Object> getUserSell(Long userId);
}
