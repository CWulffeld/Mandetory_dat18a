package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.AdminService;
import com.example.demo.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class MenuController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminService adminService;

    @Autowired
    BlogService blogService;

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
    public String login(HttpSession session, WebRequest wr, Model model){

        String user = wr.getParameter("user");
        String password = wr.getParameter("password");
        if(adminService.tjekPassword(user, password)) {
            session.setAttribute("logged_in", true);
            return "adminPage";
        }

        model.addAttribute("error", true);

        return "login";
    }

    @GetMapping("/adminPage")
    public String adminPage(Model model, HttpSession session){
        try {
            Object v = session.getAttribute("logged_in");
            if(v instanceof Boolean && (Boolean) v) {
                model.addAttribute("blog", new Blog());
                return "adminPage";
            } else {
                return "/index";
            }
        } catch (Exception ee) {
            return "/index";
        }

    }

    @PostMapping("/adminPage")
    public String gemBlog(@ModelAttribute Blog blog) throws SQLException, ClassNotFoundException {

        blogService.addBlog(blog);
        return "adminPage";
    }

    @GetMapping("/index")
    public String logout(){

        return "index";
    }
}
