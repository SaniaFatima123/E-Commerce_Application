package com.project.demo.controller;

import com.project.demo.entity.Role;
import com.project.demo.service.IRoleService;
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
    public Role createRole(@RequestBody Role role){
        return service.createUser(role);
    }
}
