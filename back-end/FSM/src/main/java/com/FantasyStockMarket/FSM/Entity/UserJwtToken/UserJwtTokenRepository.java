package com.FantasyStockMarket.FSM.Entity.UserJwtToken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserJwtTokenRepository extends JpaRepository<UserJwtToken, Long> {
}
