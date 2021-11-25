package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.service.LoginService;
import com.example.ukmaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    LoginService loginService;

//    @PostMapping("/register_process")
//    public User register(@Valid @ModelAttribute User user) throws Exception {
//        return loginService.register(user);
//    }
    @PostMapping("/registration")
    public String addUser(@Valid @ModelAttribute User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userService.createUser(user);
        System.out.println(new ResponseEntity<User>(savedUser, HttpStatus.CREATED));
        return "redirect:login";
    }
}
