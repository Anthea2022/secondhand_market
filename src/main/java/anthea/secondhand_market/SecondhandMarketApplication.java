package anthea.secondhand_market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("anthea.secondhand_market.dao")
@SpringBootApplication
public class SecondhandMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondhandMarketApplication.class, args);
    }

}
