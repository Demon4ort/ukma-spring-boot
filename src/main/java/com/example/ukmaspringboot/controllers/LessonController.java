package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.Course;
import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.service.CourseService;
import com.example.ukmaspringboot.service.LessonService;
import com.example.ukmaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private LessonService lessonService;

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


    @PutMapping("/{lessonId}/courses/{courseId}")
    Lesson addLessonToCourse(
            @PathVariable Long lessonId,
            @PathVariable Long courseId
    ) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        Course course = courseService.getCourseById(courseId);
        lesson.setCourse(course);
        return lessonService.createLesson(lesson);
    }



    @PutMapping("/{lessonId}/users/{userId}")
    Lesson addUserToLesson(
            @PathVariable Long lessonId,
            @PathVariable Long userId
    ) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        User user = userService.getUserById(userId);
        lesson.enrollUser(user);
        return lessonService.createLesson(lesson);
    }


}
