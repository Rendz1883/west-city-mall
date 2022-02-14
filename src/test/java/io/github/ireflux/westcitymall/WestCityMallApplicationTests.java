package io.github.ireflux.westcitymall;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.github.ireflux.westcitymall.config.RabbitMQConfig;
import io.github.ireflux.westcitymall.entity.CustomerLogin;
import io.github.ireflux.westcitymall.enums.ResponseStatus;
import io.github.ireflux.westcitymall.util.HttpClientUtils;
import io.github.ireflux.westcitymall.util.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class WestCityMallApplicationTests {

	//日期格式化
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

	//rabbit
	@Autowired
	private RabbitTemplate rabbitTemplate;



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

	@Test
	void enumTest() throws Exception {
		System.out.println(ResponseStatus.ERROR);
		System.out.println(ResponseStatus.ERROR.toString());
		System.out.println(ResponseStatus.ERROR.getMsg());
		System.out.println(ResponseStatus.ERROR.name());

	}

	@Test
	void sendMsg()throws Exception{
		String msg = "diaomai chibaba";

		try{
			String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
			String sendTime = sdf.format(new Date());
			Map<String, Object> msgMap = new HashMap<>();
			msgMap.put("msgId",msgId);
			msgMap.put("sendTime", sendTime);
			msgMap.put("msg", msg);
			rabbitTemplate.convertAndSend(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE,RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING,msgMap);
		}catch (Exception e){
			e.printStackTrace();
		}
	}


	}





