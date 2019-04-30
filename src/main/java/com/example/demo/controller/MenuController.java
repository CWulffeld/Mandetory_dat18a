package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

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

    @PostMapping("/login")
    public String login(HttpSession session, WebRequest wr){

        String user = wr.getParameter("user");
        String password = wr.getParameter("password");
        if(user.equals("admin") && password.equals("test")) {
            session.setAttribute("logged_in", true);
            return "adminPage";
        }

        return "login";
    }


//    @GetMapping("/adminPage")
//    public String adminPage(){
//        log.info("adminPage action called...");
//
//        log.info("adminPage action ended...");
//
//        return "adminPage";
//    }


    @GetMapping("/index")
    public String logout(){

        return "index";
    }
}
