package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.service.LoginService;
import com.example.ukmaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    LoginService loginService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @PostMapping("/registration")
    public String addUser(@Valid @ModelAttribute("regForm") User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "redirect:/index";
        }
        User savedUser = loginService.register(user);
        System.out.println(new ResponseEntity<>(savedUser, HttpStatus.CREATED));
        return "redirect:/login";
    }
}
