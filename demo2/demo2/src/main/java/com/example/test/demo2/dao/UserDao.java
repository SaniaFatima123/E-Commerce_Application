package com.example.test.demo2.dao;

import com.example.test.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
}