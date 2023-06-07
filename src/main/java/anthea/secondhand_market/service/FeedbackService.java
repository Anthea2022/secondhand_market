package anthea.secondhand_market.service;

import anthea.secondhand_market.domain.Feedback;
import anthea.secondhand_market.util.BaseResponse;

/**
 * @author anthea
 * @date 2023/6/6 14:30
 */
public interface FeedbackService {
    BaseResponse<Object> add(Feedback feedback);

    BaseResponse<Object> selectByUserId(Long userId);
}
