package com.example.ukmaspringboot.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CrudAdminController {
    @GetMapping("/add")
    public String registration(Model model) {
//        model.addAttribute("course", new Course());
        return "addCourse";
    }
}
