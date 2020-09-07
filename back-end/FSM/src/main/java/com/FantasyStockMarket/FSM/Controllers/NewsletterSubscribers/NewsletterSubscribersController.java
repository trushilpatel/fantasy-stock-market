package com.FantasyStockMarket.FSM.Controllers.NewsletterSubscribers;

import com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers.NewsletterSubscribers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/newsletter_subscriber")
@CrossOrigin("http://localhost:8081")
public class NewsletterSubscribersController {

    @Autowired
    private  NewsletterSubscribersServices nsServices;


    @GetMapping("")
    List<NewsletterSubscribers> getAllNewsletterSubscribers(){
        return nsServices.getAllNewslettersSubscribers();
    }

    @PostMapping("")
    NewsletterSubscribers saveNewSubscriber(@RequestBody NewsletterSubscribers newSubscriber){
        return nsServices.saveNewSubscriber(newSubscriber);
    }
}
