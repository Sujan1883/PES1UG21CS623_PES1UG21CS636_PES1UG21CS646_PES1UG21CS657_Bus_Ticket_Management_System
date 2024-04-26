package com.code.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.rest.entity.Admin;
import com.code.rest.entity.Login;

import com.code.rest.repository.AdminRepository;
import com.code.rest.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService { // Implement AdminService interface
    @Autowired
    AdminRepository rep;
    
    @Override // Override the method defined in the interface
    public Boolean check(Login loginInfo) {
        Admin user = rep.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());
        return user != null;
    }
}
