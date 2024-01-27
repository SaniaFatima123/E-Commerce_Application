package com.example.test.demo2.service;

import com.example.test.demo2.dao.RoleDao;
import com.example.test.demo2.dao.UserDao;
import com.example.test.demo2.entity.Role;
import com.example.test.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        adminUser.setUserPassword(getEncodedPassword("123456"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        //saving the Users in dao
        userDao.save(adminUser);

//        //creating normal user
//        User user = new User();
//        user.setUserName("Shah@123");
//        user.setUserFirstName("Shah");
//        user.setUserLastName("Sidd");
//        user.setUserPassword(getEncodedPassword("123456"));
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRoles(userRoles);
//        //saving the Users in dao
//        userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoles(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        System.out.println("Password encoded");

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        System.out.println("Password encoding");
        return passwordEncoder.encode(password);
    }
}


