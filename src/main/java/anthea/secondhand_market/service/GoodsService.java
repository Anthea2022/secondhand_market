package anthea.secondhand_market.service;

import anthea.secondhand_market.domain.Goods;
import anthea.secondhand_market.util.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author anthea
 * @date 2023/4/25 9:21
 */
public interface GoodsService extends IService<Goods> {
    BaseResponse<Object> listGoods();

    BaseResponse<Object> getGoodsLikeName(String name);
}
