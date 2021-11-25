package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "reg";
    }
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
