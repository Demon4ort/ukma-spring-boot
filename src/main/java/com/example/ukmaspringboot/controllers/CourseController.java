package com.example.ukmaspringboot.controllers;

import com.example.ukmaspringboot.entities.Course;
import com.example.ukmaspringboot.entities.User;

import com.example.ukmaspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/courses")
    public class CourseController {
        @Autowired
        private CourseService courseService;

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

        @DeleteMapping("/user/{id}")
        public String deleteCourse(@PathVariable Long id) {
            return courseService.deleteCourseById(id);
        }
    }


