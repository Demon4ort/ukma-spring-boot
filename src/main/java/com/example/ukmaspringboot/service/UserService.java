package com.example.ukmaspringboot.service;

import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        User oldUser=null;
        Optional<User> optionaluser=userRepository.findById(user.getUserId());
        if(optionaluser.isPresent()) {
            oldUser=optionaluser.get();
            oldUser.setName(user.getName());
            oldUser.setSurname(user.getSurname());
            userRepository.save(oldUser);
        }else {
            return new User();
        }
        return oldUser;
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User got deleted";
    }


//


}
