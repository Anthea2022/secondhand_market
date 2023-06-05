package anthea.secondhand_market;

import anthea.secondhand_market.dao.GoodsMapper;
import anthea.secondhand_market.dao.SellMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SecondhandMarketApplicationTests {
    @Resource
    GoodsMapper goodsMapper;

    @Test
    void contextLoads() {
        System.out.println(goodsMapper.queryById(1L));
    }
}
