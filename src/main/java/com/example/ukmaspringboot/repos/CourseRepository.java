package com.example.ukmaspringboot.repos;

import com.example.ukmaspringboot.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findByName(String name);
}
