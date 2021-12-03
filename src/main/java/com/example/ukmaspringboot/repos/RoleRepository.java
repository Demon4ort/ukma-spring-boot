package com.example.ukmaspringboot.repos;

import com.example.ukmaspringboot.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
