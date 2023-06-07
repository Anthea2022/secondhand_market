package anthea.secondhand_market.dao;

import anthea.secondhand_market.domain.Feedback;

import java.util.List;

/**
 * @author anthea
 * @date 2023/6/6 14:21
 */
public interface FeedbackMapper {
    void add(Feedback feedback);

    List<Feedback> selectByUserId(Long adminId);
}
