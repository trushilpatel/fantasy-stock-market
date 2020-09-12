package com.FantasyStockMarket.FSM.Controllers.UserAccount;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.FantasyStockMarket.FSM.Entity.User.UserRepository;
import com.FantasyStockMarket.FSM.Entity.UserAccount.UserAccount;
import com.FantasyStockMarket.FSM.Entity.UserAccount.UserAccountRepository;
import com.FantasyStockMarket.FSM.Entity.UserShares.UserShares;
import com.FantasyStockMarket.FSM.Entity.UserShares.UserSharesRepository;
import com.FantasyStockMarket.FSM.Entity.UserTransactions.UserTransactions;
import com.FantasyStockMarket.FSM.Entity.UserTransactions.UserTransactionsRepository;
import com.FantasyStockMarket.FSM.Entity.UserWatchlist.UserWatchlist;
import com.FantasyStockMarket.FSM.Entity.UserWatchlist.UserWatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAccountServices {
    private Integer NewUserDefaultBalance = 10000;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserTransactionsRepository userTransactionsRepository;
    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    UserWatchlistRepository userWatchlistRepository;
    @Autowired
    UserSharesRepository userSharesRepository;

    public UserAccountServices() {
    }

    public List<UserTransactions> getTransactions(User user) {
        User existUser = userRepository.findByEmailId(user.getEmailId());
        return existUser.getUserTransactions();
    }

    public User saveTransaction(User user) {
        User existUser = userRepository.findByEmailId(user.getEmailId());

        if (existUser != null) {
            try {
                if (this.saveUserShares(existUser, user.getUserTransactions())) {
                    existUser.addUserTransactions(user.getUserTransactions());
                    userRepository.save(existUser);
                    existUser = userRepository.findByEmailId(user.getEmailId());
                    return existUser;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public UserAccount getAccountBalance(User user) {
        User existUser = userRepository.findByEmailId(user.getEmailId());
        return existUser.getUserAccount();
    }

    public UserAccount saveAccountBalance(User user, Long amount) {

        return null;
    }

    public List<UserWatchlist> getUserWatchlist(User user) {
        User existUser = userRepository.findByEmailId(user.getEmailId());

        if (existUser != null) {
            try {
                return existUser.getUserWatchlist();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<UserWatchlist> saveUserWatchlist(User user) {
        User existUser = userRepository.findByEmailId(user.getEmailId());

        if (existUser != null) {
            try {
                existUser.addUserWatchlist(user.getUserWatchlist());
                userRepository.save(existUser);
                return existUser.getUserWatchlist();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public UserAccount saveNewUserInitialBalance(User user) {
        User existUser = userRepository.findByEmailId(user.getEmailId());

        if (existUser != null) {
            try {
                UserAccount userAccount = new UserAccount(NewUserDefaultBalance.longValue());
                userAccount.setUser(existUser);
                return userAccountRepository.save(userAccount);
            } catch (Exception userAlreadyExist) {
                return existUser.getUserAccount();
            }
        }
        return null;
    }

    public boolean saveUserShares(User existUser, List<UserTransactions> userTransactions) {
        try {
            List<UserShares> existUserShares = existUser.getUserShares();

            for (UserShares existUserShare : existUserShares) {
                for (UserTransactions userTransaction : userTransactions) {

                    if (userTransaction.getSharesQuantity() == 0) {
                        return false;
                    }

                    if (userTransaction.getSymbol().toLowerCase().equals(existUserShare.getSymbol().toLowerCase())) {
                        UserAccount userAccount = existUser.getUserAccount();
                        userAccount.setUser(existUser);

                        if (userTransaction.getTransactionType().toLowerCase().equals("sell")
                                && userTransaction.getSharesQuantity() <= existUserShare.getSharesQuantity()
                        ) {
                            // Update User account
                            Long amount = userAccount.getAmount() +
                                    userTransaction.getSharesQuantity() * userTransaction.getSharePrice();
                            userAccount.setAmount(amount);
                            userAccountRepository.save(userAccount);

                            // sell shares
                            int shareQuantity = existUserShare.getSharesQuantity() - userTransaction.getSharesQuantity();
                            existUserShare.setUser(existUser);
                            existUserShare.setSharesQuantity(shareQuantity);
                            userSharesRepository.save(existUserShare);
                            return true;

                        } else if (userTransaction.getTransactionType().toLowerCase().equals("buy")
                                && (userTransaction.getSharesQuantity() * userTransaction.getSharePrice())
                                <= existUser.getUserAccount().getAmount()) {

                            // Update User account
                            Long amount = userAccount.getAmount() -
                                    userTransaction.getSharesQuantity() * userTransaction.getSharePrice();
                            userAccount.setAmount(amount);
                            userAccountRepository.save(userAccount);

                            // sell shares
                            int shareQuantity = existUserShare.getSharesQuantity() + userTransaction.getSharesQuantity();
                            existUserShare.setUser(existUser);
                            existUserShare.setSharesQuantity(shareQuantity);
                            userSharesRepository.save(existUserShare);
                            return true;
                        }
                    }
                }
            }

            // No Symbol is Matched
            // create New Symbol in UserShares
            for (UserTransactions userTransaction : userTransactions) {
                if (userTransaction.getSharesQuantity() == 0) {
                    return false;
                }
                UserShares userShares = new UserShares();

                userShares.setUser(existUser);
                userShares.setSharesQuantity(userTransaction.getSharesQuantity());
                userShares.setSymbol(userTransaction.getSymbol());

                userSharesRepository.save(userShares);

                UserAccount userAccount = existUser.getUserAccount();
                userAccount.setUser(existUser);
                //  ADVANCED : FOR SELLING SHARE BEFORE BUYING
                //                if (userTransaction.getTransactionType().toLowerCase().equals("sell")) {
                //                    // Update User account
                //                    Long amount = userAccount.getAmount() +
                //                            userTransaction.getSharesQuantity() * userTransaction.getSharePrice();
                //                    userAccount.setAmount(amount);
                //                    userAccountRepository.save(userAccount);
                //
                //                } else
                if (userTransaction.getTransactionType().toLowerCase().equals("sell")) {
                    return false;
                } else if (userTransaction.getTransactionType().toLowerCase().equals("buy")) {
                    // Update User account
                    Long amount = userAccount.getAmount() -
                            userTransaction.getSharesQuantity() * userTransaction.getSharePrice();
                    userAccount.setAmount(amount);
                    userAccountRepository.save(userAccount);
                }
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<UserShares> getUserShares(User user) {
        User existUser = userRepository.findByEmailId(user.getEmailId());

        if (existUser != null) {
            try {
                return existUser.getUserShares();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
