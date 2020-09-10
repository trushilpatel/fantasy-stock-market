package com.FantasyStockMarket.FSM.Entity.UserSignOutHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserSignOutHistoryRepository extends JpaRepository<UserSignOutHistory, Long> {
}
