package com.example.test.demo2.controller;

//import jakarta.annotation.PostConstruct;
import com.example.test.demo2.entity.User;
import com.example.test.demo2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @PostConstruct
    public  void initRoleAndUser(){
        userService.initRoleAndUser();
    }
    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

}
