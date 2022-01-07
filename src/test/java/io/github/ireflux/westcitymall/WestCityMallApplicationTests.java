package io.github.ireflux.westcitymall;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.github.ireflux.westcitymall.entity.CustomerLogin;
import io.github.ireflux.westcitymall.util.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@SpringBootTest
class WestCityMallApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void tokenGet(){
		String userName= "赵新羊";
		String password = "123456";
		CustomerLogin customerLogin = new CustomerLogin();
		customerLogin.setLoginName(userName);
		customerLogin.setPassword(password);

		String token = TokenUtil.getToken(customerLogin);

		System.out.println(token);
	}

	@Test
	void fdfsUpload(){
		byte[] bytes = "fdsfdfaf".getBytes(StandardCharsets.UTF_8);
		ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
		FastFileStorageClient fastFileStorageClient = null;
		StorePath storePath = fastFileStorageClient.uploadFile(byteStream,bytes.length,"fdfdfsd",null);

		System.out.println(storePath.getFullPath());
	}

}
