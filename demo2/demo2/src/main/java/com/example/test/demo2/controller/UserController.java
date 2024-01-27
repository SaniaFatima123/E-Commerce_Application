package com.example.test.demo2.controller;

//import jakarta.annotation.PostConstruct;
import com.example.test.demo2.entity.User;
import com.example.test.demo2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(@RequestBody User user){
        return "This is for Admin";
    }
    @GetMapping("/forUser")
    @PreAuthorize("hasRole('User')")
    public String forUser(@RequestBody User user){
        return "This is for User";
    }

}
