package com.FantasyStockMarket.FSM.Entity.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user")
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "email_id")
    String email_id;

    @Column(name = "password")
    String password;

    @Column(name = "joined_date", insertable = false)
    Date joined_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(Date joined_date) {
        this.joined_date = joined_date;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", email_id='" + email_id + '\'' +
                ", password='" + password + '\'' +
                ", joined_date='" + joined_date + '\'' +
                '}';
    }
}
