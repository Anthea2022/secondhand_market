package anthea.secondhand_market.dao;

import anthea.secondhand_market.domain.Notice;

import java.util.List;

/**
 * @author anthea
 * @date 2023/6/6 11:33
 */
public interface NoticeMapper {
    void add(Notice notice);

    List<Notice> selectByUserId(Long userId);
}
