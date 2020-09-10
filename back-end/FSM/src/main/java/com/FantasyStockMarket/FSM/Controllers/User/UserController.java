package com.FantasyStockMarket.FSM.Controllers.User;

import com.FantasyStockMarket.FSM.Entity.User.User;
import com.FantasyStockMarket.FSM.Entity.UserJwtToken.UserJwtToken;
import com.FantasyStockMarket.FSM.Utils.Message;
import com.FantasyStockMarket.FSM.Utils.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:8081")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("")
    public List<User> getUsers() {
        return userServices.getAllUser();
    }

    @PostMapping("/sign-up")
    public Object signUpUser(@RequestBody User user) {
        /*
            Return:
                JwtToken on successful SignUp
                Message on User Already Exist
         */
        return userServices.signUp(user);
    }

    @PostMapping("/sign-in")
    public Object signInUser(@RequestBody User user) {
        /*
            Return:
                JwtToken on successful SignUp
                Message on User Already Exist
         */
        return userServices.signIn(user);
    }

    @PostMapping("/sign-out")
    public Object signOutUser(@RequestBody UserJwtToken userJwtToken) {
        return userServices.signOutUser(userJwtToken);
    }

    @PatchMapping("")
    public Object updateUser(@RequestBody UpdateUser updateUser) {
        /*
            Return:
                JwtToken on successful SignUp
                Message on User Already Exist
         */

        return userServices.updateUser(updateUser);
    }

    @PostMapping("/delete")
    public Message deleteUser(@RequestBody User user) {
        return userServices.deleteUser(user);
    }
}
