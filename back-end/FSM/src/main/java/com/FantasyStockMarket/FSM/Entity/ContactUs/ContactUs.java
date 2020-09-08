package com.FantasyStockMarket.FSM.Entity.ContactUs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "contact_us")
public class ContactUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "subject")
    String subject;

    @Column(name = "submitted_timestamp", insertable = false)
    Timestamp submittedTimestamp;

    ContactUs() {
    }

    public ContactUs(String name, String emailId, String subject) {
        this.name = name;
        this.emailId = emailId;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Timestamp getSubmittedTimestamp() {
        return submittedTimestamp;
    }

    public void setSubmittedTimestamp(Timestamp submittedTimestamp) {
        this.submittedTimestamp = submittedTimestamp;
    }

    @Override
    public String toString() {
        return "ContactUs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", subject='" + subject + '\'' +
                ", submittedTimestamp=" + submittedTimestamp +
                '}';
    }
}
