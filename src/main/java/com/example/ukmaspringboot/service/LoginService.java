package com.example.ukmaspringboot.service;

import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.repos.RoleRepository;
import com.example.ukmaspringboot.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    public User register(User user) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        if (userRepository.findUserByEmail(user.getEmail()) != null) {
            throw new Exception("user already exists");
        } else {
            userRepository.save(user);
        }
        return user;
    }
}
