package com.example.test.demo2.service;

import com.example.test.demo2.dao.RoleDao;
import com.example.test.demo2.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleDao dao;

    @Override
    public Role createNewRole(Role role) {

        return dao.save(role);
    }
}