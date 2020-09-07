package com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "newsletter_subscribers")
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsletterSubscribers {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email_id")
    private String email_id;

    @Column(name = "joined_date", insertable = false)
    private Date joined_date;

    public int getId() {
        return id;
    }
    public NewsletterSubscribers(){}
    public NewsletterSubscribers(String email_id){
        this.email_id = email_id;
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

    public Date getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(Date joined_date) {
        this.joined_date = joined_date;
    }

    @Override
    public String toString() {
        return "NewsLetterSubscribers{" +
                "id=" + id +
                ", email_id='" + email_id + '\'' +
                ", joined_date=" + joined_date +
                '}';
    }
}
