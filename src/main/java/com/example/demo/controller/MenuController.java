package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index() {
        return "index";
    }



    @GetMapping("/login")
    public String login(){
        log.info("login action called...");

        log.info("login action ended...");

        return "login";
    }


    @GetMapping("/adminPage")
    public String adminPage(){
        log.info("adminPage action called...");

        log.info("adminPage action ended...");

        return "adminPage";
    }


    @GetMapping("/home")
    public String logout(){

        return "home";
    }
}
