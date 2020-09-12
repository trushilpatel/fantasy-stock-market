package com.FantasyStockMarket.FSM.Controllers.UserAccount;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.FantasyStockMarket.FSM.Entity.UserAccount.UserAccount;
import com.FantasyStockMarket.FSM.Entity.UserShares.UserShares;
import com.FantasyStockMarket.FSM.Entity.UserTransactions.UserTransactions;
import com.FantasyStockMarket.FSM.Entity.UserWatchlist.UserWatchlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAccountController {

    @Autowired
    UserAccountServices userAccountServices;

    @PostMapping("/get-transactions")
    List<UserTransactions> getTransactions(@RequestBody User user) {
        return userAccountServices.getTransactions(user);
    }

    @PostMapping("/transactions")
    User saveTransactions(@RequestBody User user) {
        return userAccountServices.saveTransaction(user);
    }

    @PostMapping("/user-shares")
    UserShares saveUserShares(@RequestBody User user) {
        return null;
    }

    @PostMapping("/get-user-shares")
    List<UserShares> getUserShares(@RequestBody User user) {
        return userAccountServices.getUserShares(user);
    }

    @PostMapping("/account-balance")
    UserAccount getAccountBalance(@RequestBody User user) {
        return userAccountServices.getAccountBalance(user);
    }

    @PostMapping("/new-user-balance")
    UserAccount newUserInitialBalance(@RequestBody User user) {
        return userAccountServices.saveNewUserInitialBalance(user);
    }

    @PostMapping("/get-watchlist")
    List<UserWatchlist> getUserWatchlist(@RequestBody User user) {
        return userAccountServices.getUserWatchlist(user);
    }

    @PostMapping("/watchlist")
    List<UserWatchlist> saveUserWatchlist(@RequestBody User user) {
        return userAccountServices.saveUserWatchlist(user);
    }
}
