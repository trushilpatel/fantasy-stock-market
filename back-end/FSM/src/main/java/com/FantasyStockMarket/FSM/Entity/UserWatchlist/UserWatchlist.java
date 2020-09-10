package com.FantasyStockMarket.FSM.Entity.UserWatchlist;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "user_watchlist")
public class UserWatchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Long id;

    @Column(name = "user_id")
    String userId;

    @Column(name = "symbol")
    String symbol;

    public UserWatchlist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "UserWatchlist{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
