package com.FantasyStockMarket.FSM.Utils;

import com.FantasyStockMarket.FSM.Entity.UserJwtToken.UserJwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    @Value("${JWT_SIGNING_KEY}")
    String JWTSignKey;

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public UserJwtToken createJWT(Long id, String email) {

        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(email)
                .claim("email", email)
                .signWith(this.signatureAlgorithm, JWTSignKey);

        return new UserJwtToken(id, jwtBuilder.compact());
    }

    public String parseJWT(UserJwtToken jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWTSignKey)
                .parseClaimsJws(jwt.getToken()).getBody();

        return (String) claims.get("email");
    }

}
