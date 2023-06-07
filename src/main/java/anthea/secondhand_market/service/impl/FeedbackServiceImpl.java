package anthea.secondhand_market.service.impl;

import anthea.secondhand_market.dao.FeedbackMapper;
import anthea.secondhand_market.domain.Feedback;
import anthea.secondhand_market.service.FeedbackService;
import anthea.secondhand_market.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author anthea
 * @date 2023/6/6 14:30
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public BaseResponse<Object> add(Feedback feedback) {
        feedbackMapper.add(feedback);
        return BaseResponse.success("发送成功");
    }

    @Override
    public BaseResponse<Object> selectByUserId(Long userId) {
        return BaseResponse.success(feedbackMapper.selectByUserId(userId));
    }
}
