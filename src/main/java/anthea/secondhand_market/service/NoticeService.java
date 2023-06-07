package anthea.secondhand_market.service;

import anthea.secondhand_market.domain.Notice;
import anthea.secondhand_market.util.BaseResponse;

/**
 * @author anthea
 * @date 2023/6/6 11:44
 */
public interface NoticeService {
    BaseResponse<Object> add(Notice notice);

    BaseResponse<Object> selectByUserId(Long userId);
}
