package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }
//    @PostMapping("/addUser")
//    public User addUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return userService.createUsers(users);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
    }



