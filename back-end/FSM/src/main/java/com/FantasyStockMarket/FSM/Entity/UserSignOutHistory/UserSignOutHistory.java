
package com.FantasyStockMarket.FSM.Entity.UserSignOutHistory;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_sign_out_history")
public class UserSignOutHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "sign_out_timestamp", insertable = false)
    Timestamp signInTimestamp;

    public UserSignOutHistory() {
    }

    public UserSignOutHistory(Long userId) {
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
        return "SignOutHistoryRepository{" +
                "id=" + id +
                ", userId=" + userId +
                ", signInTimestamp=" + signInTimestamp +
                '}';
    }
}
