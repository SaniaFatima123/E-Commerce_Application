package com.project.demo.service;

import com.project.demo.dao.RoleDao;
import com.project.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
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
