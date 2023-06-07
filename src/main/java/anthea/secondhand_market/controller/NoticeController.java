package anthea.secondhand_market.controller;

import anthea.secondhand_market.domain.Notice;
import anthea.secondhand_market.service.NoticeService;
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
 * @date 2023/6/6 12:02
 */
@RestController
@RequestMapping("/secondhand_market/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    @PostMapping("/add")
    public BaseResponse<Object> add(@NotNull Long userTo, @NotNull Long userFrom, @NotBlank String msg) {
        Notice notice = new Notice();
        notice.setUserFrom(userFrom);
        notice.setUserTo(userTo);
        notice.setMsg(msg);
        return noticeService.add(notice);
    }

    @GetMapping("/user/select")
    public BaseResponse<Object> selectByUserId(@NotNull Long userId) {
        return noticeService.selectByUserId(userId);
    }
}
