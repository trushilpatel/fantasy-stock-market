package com.FantasyStockMarket.FSM.Entity.Newsletter_Subscribers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NewsletterSubscribersRepository extends JpaRepository<NewsletterSubscribers, Long> {
    long deleteByEmailId(String email_id);
}
