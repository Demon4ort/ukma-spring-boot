package com.example.ukmaspringboot.service;

import com.example.ukmaspringboot.entities.Course;
import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.repos.CourseRepository;
import com.example.ukmaspringboot.repos.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;


    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public List<Lesson> getLessons() {
        return lessonRepository.findAll();
    }

    public Lesson updateLesson(Lesson lesson) {
        Lesson oldLesson=null;
        Optional<Lesson> optionalLesson=lessonRepository.findById(lesson.getLessonId());
        if(optionalLesson.isPresent()) {
            oldLesson=optionalLesson.get();
            oldLesson.setCourse(lesson.getCourse());
            oldLesson.setDay(lesson.getDay());
            oldLesson.setGroup(lesson.getGroup());
            oldLesson.setTime(lesson.getTime());
            oldLesson.setEnrolledUsers(lesson.getEnrolledUsers());
        }else {
            return new Lesson();
        }
        return oldLesson;
    }

    public String deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
        return "Lesson got deleted";
    }
}
