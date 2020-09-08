package com.FantasyStockMarket.FSM.Controllers.User;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.FantasyStockMarket.FSM.Entity.User.UserRepository;
import com.FantasyStockMarket.FSM.Response.Message;
import com.FantasyStockMarket.FSM.Utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordManager passwordManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Message saveUser(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        try {
            userRepository.save(user);
            return new Message("successfully Signed up", "200");
        } catch (Exception userAlreadyExist) {
            return new Message(
                    "User Already Exist",
                    "404"
            );
        }
    }

    public Message deleteUser(User user) {
        try {
            User existUser = userRepository.findByEmailId(user.getEmailId());

            if (existUser != null && bCryptPasswordEncoder.matches(user.getPassword(), existUser.getPassword())) {
                userRepository.deleteByEmailId(user.getEmailId());
            } else {
                return new Message(
                        "Please Enter Valid Email Id and Password ",
                        "401"
                );
            }
        } catch (Exception userNotExist) {

        }

        return new Message(
                "Successfully Removed " + user.getEmailId(),
                "202"
        );
    }

    public Object updateUser(User user) {
        try {
            User updatedUser = userRepository.findByEmailId(user.getEmailId());

            updatedUser.setEmailId(user.getEmailId());
            updatedUser.setPassword(user.getPassword());

            return userRepository.save(updatedUser);
        } catch (Exception userIsNotExist) {
            return new Message(
                    "User Does Not Exist",
                    "404"
            );
        }

    }

    public Message findUser(User user) {
        User existUser = userRepository.findByEmailId(user.getEmailId());

        if (existUser != null && bCryptPasswordEncoder.matches(user.getPassword(), existUser.getPassword())) {
            return new Message("successfully Logged In", "200");
        }
        return new Message(
                "User Does Not Exist",
                "404"
        );
    }
}
