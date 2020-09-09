package com.FantasyStockMarket.FSM.Controllers.NewsletterSubscribers;

import com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers.NewsletterSubscribers;
import com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers.NewsletterSubscribersRepository;
import com.FantasyStockMarket.FSM.Utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class NewsletterSubscribersServices {
    @Autowired
    private NewsletterSubscribersRepository nsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    List<NewsletterSubscribers> getAllNewslettersSubscribers() {
        return nsRepository.findAll();
    }

    NewsletterSubscribers saveNewSubscriber(NewsletterSubscribers newSubscriber) {
        try {
            return nsRepository.save(newSubscriber);
        } catch (Exception userAlreadyExist) {
            TypedQuery<NewsletterSubscribers> query = entityManager.createQuery(
                    "select ns from NewsletterSubscribers ns",
                    NewsletterSubscribers.class);

            List<NewsletterSubscribers> result = query.getResultList();
            return result.get(0);
        }
    }

    Message deleteSubscriber(NewsletterSubscribers subscriber) {
        try {
            nsRepository.deleteByEmailId(subscriber.getEmailId());
        } catch (Exception subscriberNotExist){

        }

        return new Message(
                "Successfully Removed " + subscriber.getEmailId() + " from Newsletter Subscriptions...",
                "202"
        );
    }
}
