package com.FantasyStockMarket.FSM.Controllers.User;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.FantasyStockMarket.FSM.Entity.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return  userRepository.findAll();
    }

}
