package anthea.secondhand_market.controller;

import anthea.secondhand_market.service.AdminService;
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
 * @date 2023/6/6 11:18
 */
@RestController
@RequestMapping("/secondhand_market/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public BaseResponse<Object> login(@NotBlank String name, @NotBlank String password) {
        return adminService.login(name, password);
    }

    @PostMapping("/user/delete")
    public BaseResponse<Object> deleteUser(@NotNull Long userId) {
        return adminService.deleteUser(userId);
    }

    @GetMapping("/user/select")
    public BaseResponse<Object> selectByUserId(@NotNull Long userId) {
        return adminService.selectByUserId(userId);
    }
}
