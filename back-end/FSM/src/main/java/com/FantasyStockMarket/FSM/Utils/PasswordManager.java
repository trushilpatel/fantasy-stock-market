package com.FantasyStockMarket.FSM.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class PasswordManager {

    @Value("${JWT_SIGNING_KEY}")
    String JWTSignKey;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String createJWT(String id, String email) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        JwtBuilder jwtBuilder = Jwts.builder().setId(id)
                .setSubject(email)
                .claim("id", id)
                .claim("email", email)
                .signWith(signatureAlgorithm, JWTSignKey);

        return jwtBuilder.compact();
    }

    public void parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(JWTSignKey)
                .parseClaimsJws(jwt).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
    }
}
