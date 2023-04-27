package anthea.secondhand_market.controller;

import anthea.secondhand_market.service.GoodsService;
import anthea.secondhand_market.util.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * @author anthea
 * @date 2023/4/25 20:34
 */
@RestController
@RequestMapping("/secondhand_market/goods")
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @GetMapping("/listGoods")
    public BaseResponse<Object> listGoods() {
        return goodsService.listGoods();
    }

    @GetMapping("/getGoodsLikeName")
    public BaseResponse<Object> getGoodsLikeName(@NotBlank String name) {
        return goodsService.getGoodsLikeName(name);
    }
}
