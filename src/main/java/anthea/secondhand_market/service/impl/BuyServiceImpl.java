package anthea.secondhand_market.service.impl;

import anthea.secondhand_market.dao.BuyMapper;
import anthea.secondhand_market.domain.Buy;
import anthea.secondhand_market.service.BuyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anthea
 * @date 2023/4/25 9:28
 */
@Service
@Transactional
public class BuyServiceImpl extends ServiceImpl<BuyMapper, Buy>
       implements BuyService {
}
