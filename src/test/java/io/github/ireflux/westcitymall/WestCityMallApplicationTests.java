package io.github.ireflux.westcitymall;

import io.github.ireflux.westcitymall.entity.CustomerLogin;
import io.github.ireflux.westcitymall.util.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
