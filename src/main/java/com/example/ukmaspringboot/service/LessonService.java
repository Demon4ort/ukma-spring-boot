package com.example.ukmaspringboot.service;

import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.repos.LessonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    private Logger logger = LoggerFactory.getLogger(LessonService.class);

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
        MDC.put("id", lesson.getLessonId().toString());
        Lesson oldLesson = new Lesson();
        Optional<Lesson> optionalLesson = lessonRepository.findById(lesson.getLessonId());
        if (optionalLesson.isPresent()) {
            oldLesson = optionalLesson.get();
            oldLesson.setCourse(lesson.getCourse());
            oldLesson.setDay(lesson.getDay());
            oldLesson.setGroup(lesson.getGroup());
            oldLesson.setTime(lesson.getTime());
            oldLesson.setEnrolledUsers(lesson.getEnrolledUsers());
            logger.debug("Updated lesson");
        } else {
            logger.error("Lesson not found");
        }
        return oldLesson;
    }

    public String deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
        logger.debug("Deleted lesson");
        return "Lesson got deleted";
    }
}
