package com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "newsletter_subscribers")
public class NewsletterSubscribers {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "joined_date", insertable = false)
    private Timestamp joinedDate;

    public NewsletterSubscribers() {
    }

    public NewsletterSubscribers(String emailId) {
        this.emailId = emailId;
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

    public Timestamp getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Timestamp joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Override
    public String toString() {
        return "NewsLetterSubscribers{" +
                "id=" + id +
                ", emailId='" + emailId + '\'' +
                ", joined_date=" + joinedDate +
                '}';
    }
}
