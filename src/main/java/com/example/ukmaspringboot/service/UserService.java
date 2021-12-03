package com.example.ukmaspringboot.service;

import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

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
        MDC.put("id", user.getUserId().toString());
        User oldUser;
        Optional<User> optionaluser = userRepository.findById(user.getUserId());
        if(optionaluser.isPresent()) {
            oldUser=optionaluser.get();
            oldUser.setName(user.getName());
            oldUser.setSurname(user.getSurname());
            userRepository.save(oldUser);
            logger.debug("Updated user");
        }else {
            logger.error("User not found");
            return new User();
        }
        return oldUser;
    }

    public String deleteUserById(Long id) {
        MDC.put("id", id.toString());
        userRepository.deleteById(id);
        logger.debug("Deleted user");
        return "User got deleted";
    }


//


}

