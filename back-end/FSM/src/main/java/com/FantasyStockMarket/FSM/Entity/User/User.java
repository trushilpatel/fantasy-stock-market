package com.FantasyStockMarket.FSM.Entity.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

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
        return "user{" +
                "id=" + id +
                ", email_id='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", joined_date='" + joinedDate + '\'' +
                '}';
    }
}
