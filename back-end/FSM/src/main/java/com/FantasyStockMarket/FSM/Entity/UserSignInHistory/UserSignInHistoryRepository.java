package com.FantasyStockMarket.FSM.Entity.UserSignInHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSignInHistoryRepository extends JpaRepository<UserSignInHistory, Long> {
}
