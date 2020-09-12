package com.FantasyStockMarket.FSM.Entity.UserShares;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "user_shares")
public class UserShares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    User user;

    @Column(name = "symbol")
    String symbol;

    @Column(name = "shares_quantity")
    int sharesQuantity;

    public UserShares() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getSharesQuantity() {
        return sharesQuantity;
    }

    public void setSharesQuantity(int sharesQuantity) {
        this.sharesQuantity = sharesQuantity;
    }
}

