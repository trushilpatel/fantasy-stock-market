package com.FantasyStockMarket.FSM.Entity.UserTransactions;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "user_transactions")
public class UserTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Long id;

    @Column(name = "user_id")
    String userId;

    @Column(name = "transaction_type")
    String transactionType;

    @Column(name = "symbol")
    String symbol;

    @Column(name = "amount")
    String amount;


    public UserTransactions() {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UserTransactions{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", symbol='" + symbol + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}

