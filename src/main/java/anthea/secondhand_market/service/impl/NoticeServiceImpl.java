package anthea.secondhand_market.service.impl;

import anthea.secondhand_market.dao.NoticeMapper;
import anthea.secondhand_market.domain.Notice;
import anthea.secondhand_market.service.NoticeService;
import anthea.secondhand_market.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author anthea
 * @date 2023/6/6 11:57
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;


    @Override
    public BaseResponse<Object> add(Notice notice) {
        noticeMapper.add(notice);
        return BaseResponse.success("发送成功");
    }

    @Override
    public BaseResponse<Object> selectByUserId(Long userId) {
        return BaseResponse.success(noticeMapper.selectByUserId(userId));
    }
}
