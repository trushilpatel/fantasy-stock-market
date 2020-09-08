package com.FantasyStockMarket.FSM.Controllers.ContactUs;

import com.FantasyStockMarket.FSM.Entity.ContactUs.ContactUs;
import com.FantasyStockMarket.FSM.Entity.ContactUs.ContactUsRepository;
import com.FantasyStockMarket.FSM.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ContactUsServices {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ContactUs> getAllContactUs() {
        return contactUsRepository.findAll();
    }

    public ContactUs saveContactUs(ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }

    public Message deleteContactUs(ContactUs contactUs) {
        try {
            contactUsRepository.deleteByEmailId(contactUs.getEmailId());
        } catch (Exception userNotExist) {

        }

        return new Message(
                "Successfully Removed ",
                "202"
        );
    }
}
