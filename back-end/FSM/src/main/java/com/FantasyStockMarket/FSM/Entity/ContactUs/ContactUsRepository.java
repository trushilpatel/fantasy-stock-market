package com.FantasyStockMarket.FSM.Entity.ContactUs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {
    void deleteByEmailId(String emailId);
}
