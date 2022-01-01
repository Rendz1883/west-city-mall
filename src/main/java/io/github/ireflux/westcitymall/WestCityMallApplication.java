package io.github.ireflux.westcitymall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("io.github.ireflux.westcitymall.mapper")
public class WestCityMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(WestCityMallApplication.class, args);
	}

}
