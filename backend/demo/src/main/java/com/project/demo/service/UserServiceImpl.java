package com.project.demo.service;

import com.project.demo.dao.UserDao;
import com.project.demo.entity.Role;
import com.project.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    public void initRoleAndUser(){
        //creating admin role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("This the the Admin Role");

        //creating normal role
        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("This is the Default Role for newly created records");

        //creating admin user
        User adminUser = new User();
        adminUser.setUserName("Sania@123");
        adminUser.setUserFirstName("Sania");
        adminUser.setUserLastName("Fatima");
        adminUser.setUserPassword("123456");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        //saving the Users in dao
        userDao.save(adminUser);

        //creating normal user
        User user = new User();
        user.setUserName("Shah@123");
        user.setUserFirstName("Shah");
        user.setUserLastName("Sidd");
        user.setUserPassword("123456");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        //saving the Users in dao
        userDao.save(user);
    }
    @Override
    public User registerNewUser(User user) {
       return userDao.save(user);
    }
}
