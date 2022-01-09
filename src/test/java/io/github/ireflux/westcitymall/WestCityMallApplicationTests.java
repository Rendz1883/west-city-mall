package io.github.ireflux.westcitymall;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.github.ireflux.westcitymall.entity.CustomerLogin;
import io.github.ireflux.westcitymall.util.HttpClientUtils;
import io.github.ireflux.westcitymall.util.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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

	@Test
	void  shortMessage() throws Exception {
		HashMap<String, Object> shortMap = new HashMap<>();
		shortMap.put("appkey","fd6939cfbfec079ba55848444c58372e");
		shortMap.put("mobile", "18831999125");
		shortMap.put("sign", "【信仰保险】");
		shortMap.put("content","感谢使用信仰保险祝你生活一直吊毛。每天有女性给您送苹果吃。\" + \"验证码：信仰吊毛】");


		String stringMap = HttpClientUtils.doPost("https://way.jd.com/chonry/smsapi", null,shortMap);

			System.out.println(stringMap);


	}

}
