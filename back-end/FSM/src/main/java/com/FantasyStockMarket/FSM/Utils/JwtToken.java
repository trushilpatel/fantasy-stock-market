package com.FantasyStockMarket.FSM.Utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtToken {

    String token;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Long id;

    public JwtToken() {
    }

    public JwtToken(Long id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JwtToken{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
