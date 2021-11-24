package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/register_process")
    public User register(@Valid @ModelAttribute User user) throws Exception {
        return loginService.register(user);
    }
}
