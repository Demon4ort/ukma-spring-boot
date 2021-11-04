package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.Course;
import com.example.ukmaspringboot.entities.User;

import com.example.ukmaspringboot.repos.CourseRepository;
import com.example.ukmaspringboot.service.CourseService;
import com.example.ukmaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/courses")
    public class CourseController {
        @Autowired
        private CourseService courseService;
        @Autowired
        private UserService userService;

        @PostMapping("/addCourse")
        public Course addCourse(@RequestBody Course course) {
            return courseService.createCourse(course);
        }

        @GetMapping("/course/{id}")
        public Course getCourseById(@PathVariable Long id) {
            return courseService.getCourseById(id);
        }

        @GetMapping("/courses")
        public List<Course> getAllCourses() {
            return courseService.getCourses();
        }

        @PutMapping("/updateCourse")
        public Course updateCourse(@RequestBody Course course) {
            return courseService.updateCourse(course);
        }

        @DeleteMapping("/course/{id}")
        public String deleteCourse(@PathVariable Long id) {
            return courseService.deleteCourseById(id);
        }

        @PutMapping("/{courseId}/students/{userId}")
        Course addUserToCourse(
                @PathVariable Long courseId,
                @PathVariable Long userId
        ) {
            Course course = courseService.getCourseById(courseId);
            User user = userService.getUserById(userId);
            course.getEnrolledUsers().add(user);
            return courseService.createCourse(course);
        }
    }


