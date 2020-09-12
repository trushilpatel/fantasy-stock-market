package com.FantasyStockMarket.FSM.Entity.UserShares;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserSharesRepository extends JpaRepository<UserShares, Integer> {
}
