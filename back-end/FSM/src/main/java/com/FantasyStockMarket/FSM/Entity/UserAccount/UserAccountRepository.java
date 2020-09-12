package com.FantasyStockMarket.FSM.Entity.UserAccount;

import com.FantasyStockMarket.FSM.Entity.UserAccount.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
