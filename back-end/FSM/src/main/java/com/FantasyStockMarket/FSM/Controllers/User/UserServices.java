package com.FantasyStockMarket.FSM.Controllers.User;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.FantasyStockMarket.FSM.Entity.User.UserRepository;
import com.FantasyStockMarket.FSM.Entity.UserJwtToken.UserJwtToken;
import com.FantasyStockMarket.FSM.Entity.UserJwtToken.UserJwtTokenRepository;
import com.FantasyStockMarket.FSM.Entity.UserSignInHistory.UserSignInHistory;
import com.FantasyStockMarket.FSM.Entity.UserSignInHistory.UserSignInHistoryRepository;
import com.FantasyStockMarket.FSM.Entity.UserSignOutHistory.UserSignOutHistory;
import com.FantasyStockMarket.FSM.Entity.UserSignOutHistory.UserSignOutHistoryRepository;
import com.FantasyStockMarket.FSM.Utils.Message;
import com.FantasyStockMarket.FSM.Utils.JwtUtils;
import com.FantasyStockMarket.FSM.Utils.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserJwtTokenRepository userJwtTokenRepository;
    private final UserSignInHistoryRepository userSignInHistoryRepository;
    private final UserSignOutHistoryRepository userSignOutHistoryRepository;

    @Autowired
    UserServices(UserRepository userRepository, UserJwtTokenRepository userJwtTokenRepository, JwtUtils jwtUtils,
                 BCryptPasswordEncoder bCryptPasswordEncoder, UserSignOutHistoryRepository userSignOutHistoryRepository,
                 UserSignInHistoryRepository userSignInHistoryRepository

    ) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userJwtTokenRepository = userJwtTokenRepository;
        this.userSignInHistoryRepository = userSignInHistoryRepository;
        this.userSignOutHistoryRepository = userSignOutHistoryRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Object signUp(User user) {
        /*
            Return:
                JwtToken on successful SignUp
                Message on User Already Exist
         */

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        try {
            userRepository.save(user);
            UserJwtToken userJwtToken = jwtUtils.createJWT(user.getId(), user.getEmailId());
            userSignInHistoryRepository.save(new UserSignInHistory(user.getId()));

            return userJwtTokenRepository.save(userJwtToken);

        } catch (Exception userAlreadyExist) {
            return new Message(
                    "User Already Exist Please Sign In",
                    "404"
            );
        }
    }

    public Object signIn(User user) {
        /*
            Return:
                JwtToken on successful SignUp
                Message on User Already Exist
         */

        // Retrieving Existing User
        User existUser = userRepository.findByEmailId(user.getEmailId());

        if (existUser == null) {
            // User Doesn't Exist

            return new Message(
                    "User Doesn't Exist Please Sign Up",
                    "404"
            );

        } else if (bCryptPasswordEncoder.matches(user.getPassword(), existUser.getPassword())) {
            // Check User Password

            UserJwtToken userJwtToken = jwtUtils.createJWT(existUser.getId(), existUser.getEmailId());
            userSignInHistoryRepository.save(new UserSignInHistory(existUser.getId()));

            return userJwtTokenRepository.save(userJwtToken);
        } else {
            // User Entered invalid password
            return new
                    Message(
                    "Please Enter Valid details ",
                    "404"
            );

        }
    }

    public Message deleteUser(User user) {
        try {
            User existUser = userRepository.findByEmailId(user.getEmailId());
            System.out.println(user);
            System.out.println(existUser);
            if (existUser != null && bCryptPasswordEncoder.matches(user.getPassword(), existUser.getPassword())) {
                System.out.println("1");
                userRepository.deleteByEmailId(user.getEmailId());
                System.out.println("2");
                userSignOutHistoryRepository.save(new UserSignOutHistory(user.getId()));

                System.out.println("Delete Account");
            } else {
                return new Message(
                        "Please Enter Valid Email Id and Password ",
                        "401"
                );
            }
        } catch (Exception userNotExist) {
            System.out.println("Exception in Delete Account");

        }
        return new Message(
                "Successfully Removed " + user.getEmailId(),
                "202"
        );
    }

    public Object updateUser(UpdateUser tempUpdateUser) {
        /*
            Return:
                JwtToken on successful UpdateUSer
                Message on User Already Exist
         */

        try {
            User updatedUser = userRepository.findByEmailId(tempUpdateUser.getEmail());

            if (bCryptPasswordEncoder.matches(tempUpdateUser.getPassword(), updatedUser.getPassword())) {
                // validating old password

                updatedUser.setEmailId(tempUpdateUser.getEmail());
                updatedUser.setPassword(bCryptPasswordEncoder.encode(tempUpdateUser.getNewPassword()));

                userRepository.save(updatedUser);

                UserJwtToken userJwtToken = jwtUtils.createJWT(updatedUser.getId(), updatedUser.getEmailId());
                userSignInHistoryRepository.save(new UserSignInHistory(updatedUser.getId()));

                return userJwtTokenRepository.save(userJwtToken);
            } else {
                return new Message(
                        "Enter Valid Details",
                        "401"
                );
            }


        } catch (Exception userIsNotExist) {
            return new Message(
                    "User Does Not Exist",
                    "404"
            );
        }

    }

    public Object signOutUser(UserJwtToken userJwtToken) {
        String email = jwtUtils.parseJWT(userJwtToken);

        try {
            User user = userRepository.findByEmailId(email);
            userSignOutHistoryRepository.save(new UserSignOutHistory(user.getId()));

        } catch (Exception userNotExist) {

        }

        return new Message(
                "Successfully Sign Out",
                "200"
        );
    }
}
