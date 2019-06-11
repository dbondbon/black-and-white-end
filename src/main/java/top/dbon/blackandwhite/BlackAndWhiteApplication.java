package top.dbon.blackandwhite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.dbon.blackandwhite.mapper")
public class BlackAndWhiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackAndWhiteApplication.class, args);

	}

}
