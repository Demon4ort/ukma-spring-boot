package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.service.LessonService;
import com.example.ukmaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;
    @CrossOrigin(origins = "http://localhost:8088")
    @PostMapping("/addLesson")
    public Lesson addLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping("/lesson/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @GetMapping("/lessons")
    public List<Lesson> getAllLessons() {
        return lessonService.getLessons();
    }

    @PutMapping("/updateLesson")
    public Lesson updateLesson(@RequestBody Lesson lesson) {
        return lessonService.updateLesson(lesson);
    }

    @DeleteMapping("/lesson/{id}")
    public String deleteLesson(@PathVariable Long id) {
        return lessonService.deleteLessonById(id);
    }




}
