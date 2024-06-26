package com.FantasyStockMarket.FSM.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    public void deleteByEmailId(String email);

    public User findByEmailId(String emailId);

    @Query("SELECT u.id from User u where u.emailId = ?1")
    public Long getUserId(String email);
}
