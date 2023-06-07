package anthea.secondhand_market.controller;

import anthea.secondhand_market.domain.Feedback;
import anthea.secondhand_market.service.FeedbackService;
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
 * @date 2023/6/6 14:33
 */
@RestController
@RequestMapping("/secondhand_market/feedback")
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @PostMapping("/add")
    public BaseResponse<Object> add(@NotBlank String msg, @NotNull Long adminId, @NotNull Long userId) {
        Feedback feedback = new Feedback();
        feedback.setMsg(msg);
        feedback.setUserId(userId);
        feedback.setAdminId(adminId);
        return feedbackService.add(feedback);
    }

    @GetMapping("/admin/get")
    public BaseResponse<Object> adminGet(@NotNull Long adminId) {
        return feedbackService.selectByUserId(adminId);
    }
}
