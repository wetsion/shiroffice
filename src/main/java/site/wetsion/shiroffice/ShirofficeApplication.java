package site.wetsion.shiroffice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("site.wetsion.shiroffice.mapper")
public class ShirofficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShirofficeApplication.class, args);
    }

}
