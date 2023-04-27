package anthea.secondhand_market.service.impl;

import anthea.secondhand_market.dao.GoodsMapper;
import anthea.secondhand_market.domain.Goods;
import anthea.secondhand_market.service.GoodsService;
import anthea.secondhand_market.util.BaseResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author anthea
 * @date 2023/4/25 9:26
 */
@Service
@Transactional
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
       implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public BaseResponse<Object> listGoods() {
        List<Goods> goodsList = goodsMapper.listAllGoods();
        return BaseResponse.success(goodsList);
    }

    @Override
    public BaseResponse<Object> getGoodsLikeName(String name) {
        List<Goods> goodsLikeName = goodsMapper.getGoodsLikeName(name);
        return BaseResponse.success(goodsLikeName);
    }
}
