package com.lingDream.llfEnglish.tool.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.util.Calendar;
import java.util.Map;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-06-28 14:44
 */
@Component
public class JWTUtils {

    /**
     * 生成token
     */
    public String getToken(Map<String, String> payload) {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1); //默认1天过期
//        instance.add(Calendar.SECOND, 20); //测试时20秒
        final JWTCreator.Builder builder = JWT.create();

        payload.forEach(builder::withClaim);

        return builder
                .withExpiresAt(instance.getTime())
                .sign(getAlgorithm());
    }

    /**
     * 验证Token
     */
    @NotEmpty
    public DecodedJWT verify(String token) {
        return JWT.require(getAlgorithm()).build().verify(token);
    }


    private Algorithm getAlgorithm(){
        String SALT = "(*@%UikKF:S";
        return Algorithm.HMAC256(SALT);
    }
}
