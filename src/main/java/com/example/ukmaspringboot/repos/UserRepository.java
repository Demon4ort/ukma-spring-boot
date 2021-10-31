package com.example.ukmaspringboot.repos;

import com.example.ukmaspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
