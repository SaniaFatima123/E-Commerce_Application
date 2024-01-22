package com.project.demo.service;

import com.project.demo.entity.User;

public interface IUserService {
  User registerNewUser(User user);
  void initRoleAndUser();
}
