package com.FantasyStockMarket.FSM.Entity.UserSignInHistory;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Component
@Table(name = "user_sign_in_history")
public class UserSignInHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "sign_in_timestamp", insertable = false)
    Timestamp signInTimestamp;

    public UserSignInHistory() {
    }
    public UserSignInHistory(Long userId){
        this.userId = userId;
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

    public Timestamp getSignInTimestamp() {
        return signInTimestamp;
    }

    public void setSignInTimestamp(Timestamp signInTimestamp) {
        this.signInTimestamp = signInTimestamp;
    }

    @Override
    public String toString() {
        return "UserSignInHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", signInTimestamp=" + signInTimestamp +
                '}';
    }
}
