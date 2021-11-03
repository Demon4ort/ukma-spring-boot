package com.example.ukmaspringboot.service;

import com.example.ukmaspringboot.entities.Course;
import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;


    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> createCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Course course) {
        Course oldCourse=null;
        Optional<Course> optionalCourse=courseRepository.findById(course.getCourseId());
        if(optionalCourse.isPresent()) {
            oldCourse=optionalCourse.get();
            oldCourse.setName(course.getName());
            oldCourse.setTeacher(course.getTeacher());
            oldCourse.setYear(course.getYear());
            courseRepository.save(oldCourse);
        }else {
            return new Course();
        }
        return oldCourse;
    }

    public String deleteCourseById(Long id) {
        courseRepository.deleteById(id);
        return "Course got deleted";
    }
}
