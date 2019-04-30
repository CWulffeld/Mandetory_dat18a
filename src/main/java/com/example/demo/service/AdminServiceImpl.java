package com.example.demo.service;


import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{


    @Override
    public boolean tjekPassword(String username, String password) {

        if (username.equals("admin") && password.equals("test")){
            return true;
        }
        return false;
    }
}
