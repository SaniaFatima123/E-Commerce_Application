package com.example.test.demo2.service;

import com.example.test.demo2.entity.User;

public interface IUserService {
    User registerNewUser(User user);
    void initRoleAndUser();
}

