package com.example.ukmaspringboot.repos;

import com.example.ukmaspringboot.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}