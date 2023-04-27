package anthea.secondhand_market.controller;

import anthea.secondhand_market.domain.Goods;
import anthea.secondhand_market.service.GoodsService;
import anthea.secondhand_market.service.UserService;
import anthea.secondhand_market.util.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author anthea
 * @date 2023/4/25 9:42
 */
@RestController
@RequestMapping("/secondhand_market/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public BaseResponse<Object> adminLogin(@NotBlank String name, @NotBlank String password) {
        return userService.login(name, password);
    }

    @PostMapping("/sell")
    public BaseResponse<Object> addGoods(@NotNull Long userId, @NotBlank String name, @NotBlank String refer,
                                         @NotNull int num, @NotNull int price, @NotBlank String img) {
        Goods goods = new Goods();
        goods.setName(name);
        goods.setRefer(refer);
        goods.setPrice(price);
        goods.setNum(num);
        goods.setImg(img);
        return userService.addGoods(userId, goods);
    }

    @PostMapping("/buy")
    public BaseResponse<Object> buy(@NotNull Long userId, @NotNull Long goodsId, @NotNull int num) {
        return userService.buy(userId, goodsId, num);
    }

    @PostMapping("/save")
    public BaseResponse<Object> save(@NotNull Long userId, @NotNull int money) {
        return userService.save(userId, money);
    }

    @GetMapping("/getUserData")
    public BaseResponse<Object> getUserData(@NotNull Long userId) {
        return userService.getUserDataById(userId);
    }
}
