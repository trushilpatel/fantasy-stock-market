package com.FantasyStockMarket.FSM.Controllers.NewsletterSubscribers;

import com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers.NewsletterSubscribers;
import com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers.NewsletterSubscribersRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class NewsletterSubscribersServices {
    @Autowired
    private NewsletterSubscribersRepository nsRepository;

    private EntityManager entityManager;

    @Autowired


    List<NewsletterSubscribers> getAllNewslettersSubscribers(){
        return nsRepository.findAll();
    }

    NewsletterSubscribers saveNewSubscriber(NewsletterSubscribers newSubscriber){
        try {
            return nsRepository.save(newSubscriber);
        } catch (Exception userAlreadyExist){
            return newSubscriber;
            //Example<NewsletterSubscribers> example = Example.of();
            //return nsRepository.findOne();
        }
    }
}
