package com.example.ukmaspringboot.repos;

import com.example.ukmaspringboot.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
}
