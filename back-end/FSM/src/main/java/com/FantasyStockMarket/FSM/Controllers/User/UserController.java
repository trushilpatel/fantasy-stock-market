package com.FantasyStockMarket.FSM.Controllers.User;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.FantasyStockMarket.FSM.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:8081")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("")
    public List<User> getUsers(){
        return userServices.getAllUser();
    }

    @PostMapping("/sign-up")
    public Message signUpUser(@RequestBody User user){
        return userServices.saveUser(user);
    }

    @PostMapping("/sign-in")
    public Message signInUser(@RequestBody User user){
        return userServices.findUser(user);
    }

    @PatchMapping("")
    public Object updateUser(@RequestBody User user){
        return userServices.updateUser(user);
    }

    @DeleteMapping("")
    public Message deleteUser(@RequestBody User user){
        return userServices.deleteUser(user);
    }
}
