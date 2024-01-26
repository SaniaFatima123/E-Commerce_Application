package com.example.test.demo2.controller;

import com.example.test.demo2.entity.Role;
import com.example.test.demo2.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private IRoleService service;
    @PostMapping("/createRole")
    public Role createNewRole(@RequestBody Role role){
        return service.createNewRole(role);
    }
}
