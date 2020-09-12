package com.FantasyStockMarket.FSM.Entity.UserTransactions;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "user_transactions")
public class UserTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    User user;

    @Column(name = "transaction_type")
    String transactionType;

    @Column(name = "symbol")
    String symbol;

    @Column(name = "share_price")
    Integer sharePrice;

    @Column(name = "shares_quantity")
    Integer sharesQuantity;

    @Column(name = "time_stamp", insertable = false)
    Timestamp timeStamp;

    public Integer getSharesQuantity() {
        return sharesQuantity;
    }

    public void setSharesQuantity(Integer sharesQuantity) {
        this.sharesQuantity = sharesQuantity;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserTransactions() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Integer sharePrice) {
        this.sharePrice = sharePrice;
    }

    @Override
    public String toString() {
        return "UserTransactions{" +
                "id=" + id +
                ", transactionType='" + transactionType + '\'' +
                ", symbol='" + symbol + '\'' +
                ", amount='" + sharePrice + '\'' +
                '}';
    }
}

