package com.FantasyStockMarket.FSM.Controllers.NewsletterSubscribers;

import com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers.NewsletterSubscribers;
import com.FantasyStockMarket.FSM.Utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/newsletter_subscriber")
@CrossOrigin("http://localhost:8081")
public class NewsletterSubscribersController {

    @Autowired
    private NewsletterSubscribersServices newsletterSubscribersServices;


    @GetMapping("")
    List<NewsletterSubscribers> getAllNewsletterSubscribers() {
        return newsletterSubscribersServices.getAllNewslettersSubscribers();
    }

    @PostMapping("")
    NewsletterSubscribers saveNewSubscriber(@RequestBody NewsletterSubscribers newSubscriber) {
        return newsletterSubscribersServices.saveNewSubscriber(newSubscriber);
    }

    @DeleteMapping("")
    @Transactional
    Message deleteSubscriber(@RequestBody NewsletterSubscribers deleteSubscriber) {
        return newsletterSubscribersServices.deleteSubscriber(deleteSubscriber);
    }
}
