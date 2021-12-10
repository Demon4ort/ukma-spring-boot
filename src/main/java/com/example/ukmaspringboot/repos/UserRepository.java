package com.example.ukmaspringboot.repos;

import com.example.ukmaspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmail(@NonNull String email);
}
