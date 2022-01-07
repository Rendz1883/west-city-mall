package io.github.ireflux.westcitymall;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(FdfsClientConfig.class)
@MapperScan("io.github.ireflux.westcitymall.mapper")
public class WestCityMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(WestCityMallApplication.class, args);
	}

}
