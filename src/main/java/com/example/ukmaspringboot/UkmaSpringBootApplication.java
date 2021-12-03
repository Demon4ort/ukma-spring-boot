package com.example.ukmaspringboot;

import com.example.ukmaspringboot.entities.Role;
import com.example.ukmaspringboot.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class UkmaSpringBootApplication {

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(UkmaSpringBootApplication.class, args);
        List<Role> roles = new LinkedList<>();
        roles.add(new Role("user"));
        roles.add(new Role("admin"));
    }

}
