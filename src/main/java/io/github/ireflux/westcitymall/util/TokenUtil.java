package io.github.ireflux.westcitymall.util;

import cn.hutool.db.nosql.redis.RedisDS;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.ireflux.westcitymall.entity.CustomerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public final class TokenUtil {



    //讲用户名存入到token中
    public static String getToken(CustomerLogin customerLogin){
        String token = "";
         token = JWT.create().withAudience(customerLogin.getLoginName())
                .sign(Algorithm.HMAC256(customerLogin.getPassword()));


        return token;

    }
}
