package io.github.ireflux.westcitymall.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.ireflux.westcitymall.entity.CustomerLogin;

public final class TokenUtil {

    //讲用户名存入到token中
    public static String getToken(CustomerLogin customerLogin){
        String token = "";
        return token = JWT.create().withAudience(customerLogin.getLoginName())
                .sign(Algorithm.HMAC256(customerLogin.getPassword()));

    }
}
