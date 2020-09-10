package com.FantasyStockMarket.FSM.Entity.UserJwtToken;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Component
@Table(name = "user_jwt_token")
public class UserJwtToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Long id;

    @Column(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Long userId;

    @Column(name = "jwt_token")
    String token;

    @Column(name = "sign_in_timestamp", insertable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Timestamp signInTimestamp;

    public UserJwtToken() {
    }

    public UserJwtToken(Long userId, String jwtToken) {
        this.userId = userId;
        this.token = jwtToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String jwtToken) {
        this.token = jwtToken;
    }

    public Timestamp getSignInTimestamp() {
        return signInTimestamp;
    }

    public void setSignInTimestamp(Timestamp signInTimestamp) {
        this.signInTimestamp = signInTimestamp;
    }

    @Override
    public String toString() {
        return "UserJwtToken{" +
                "id=" + id +
                ", userId=" + userId +
                ", jwtToken='" + token + '\'' +
                ", signInTimestamp=" + signInTimestamp +
                '}';
    }
}
