package com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface NewsletterSubscribersRepository extends JpaRepository<NewsletterSubscribers, Integer> {
}
