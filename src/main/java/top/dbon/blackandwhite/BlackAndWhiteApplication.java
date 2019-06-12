package top.dbon.blackandwhite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("top.dbon.blackandwhite.mapper")
@ComponentScan("top.dbon.blackandwhite.controller")
public class BlackAndWhiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackAndWhiteApplication.class, args);

	}

}
