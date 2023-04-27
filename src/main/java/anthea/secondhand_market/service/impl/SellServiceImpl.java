package anthea.secondhand_market.service.impl;

import anthea.secondhand_market.dao.SellMapper;
import anthea.secondhand_market.domain.Sell;
import anthea.secondhand_market.service.SellService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anthea
 * @date 2023/4/25 9:27
 */
@Service
@Transactional
public class SellServiceImpl extends ServiceImpl<SellMapper, Sell>
       implements SellService {
}
