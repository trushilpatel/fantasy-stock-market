package com.FantasyStockMarket.FSM.Entity.User;

import com.FantasyStockMarket.FSM.Entity.UserAccount.UserAccount;
import com.FantasyStockMarket.FSM.Entity.UserShares.UserShares;
import com.FantasyStockMarket.FSM.Entity.UserTransactions.UserTransactions;
import com.FantasyStockMarket.FSM.Entity.UserWatchlist.UserWatchlist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "email_id")
    String emailId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "joined_date", insertable = false)
    Timestamp joinedDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserTransactions> userTransactions;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    UserAccount userAccount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserWatchlist> userWatchlist;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserShares> userShares;

    public void addUserTransactions(List<UserTransactions> userTransactions) {
        userTransactions.forEach(userTransaction -> {
            userTransaction.setUser(this);
        });
        this.userTransactions.addAll(userTransactions);
    }

    public List<UserShares> getUserShares() {
        return userShares;
    }

    public void setUserShares(List<UserShares> userShares) {
        this.userShares = userShares;
    }

    public List<UserWatchlist> getUserWatchlist() {
        return userWatchlist;
    }

    public void setUserWatchlist(List<UserWatchlist> userWatchlist) {
        this.userWatchlist = userWatchlist;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<UserTransactions> getUserTransactions() {
        return userTransactions;
    }

    public void setUserTransactions(List<UserTransactions> userTransactions) {
        this.userTransactions = userTransactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Timestamp joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", joinedDate=" + joinedDate +
                ", userTransactions=" + userTransactions +
                ", userAccount=" + userAccount +
                ", userWatchlist=" + userWatchlist +
                '}';
    }

    public void addUserWatchlist(List<UserWatchlist> userWatchlist) {
        userWatchlist.forEach(uw -> {
            uw.setUser(this);
        });
        this.userWatchlist.addAll(userWatchlist);
    }
}
