package com.example.ukmaspringboot;

import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.repos.LessonRepository;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class LessonRepositoryTest {
    private TestEntityManager entityManager;
    @Autowired
    private LessonRepository lessonRepository;
    @Test
    public void testCourseAdding() {
        // given
        Lesson l1 = new Lesson("monday", "14:00", "3", "name1", "teacher1","3");
        lessonRepository.save(l1);

        assertThat(l1.getLessonId()!=null);
    }
    @Test
    public void LessonDeleteTest(){
        Lesson l1 = new Lesson("monday", "14:00", "3", "name1", "teacher1","3");
        lessonRepository.save(l1);
        lessonRepository.delete(l1);
        assertThat(l1.getLessonId()==null);
    }

    @Test
    public void testAllCoursesGetting(){
        Lesson l1 = new Lesson("monday", "14:00", "3", "name1", "teacher1","3");
        lessonRepository.save(l1);
        Lesson l2 = new Lesson("tuesday", "14:00", "3", "name1", "teacher1","3");
        lessonRepository.save(l2);
        Lesson l3 = new Lesson("friday", "14:00", "3", "name1", "teacher1","3");
        lessonRepository.save(l3);
        List<Lesson> courses = lessonRepository.findAll();
        AssertionsForInterfaceTypes.assertThat(courses).hasSize(3).contains(l1,l2,l3);
    }

    @Test
    public void updateLessonTest(){
        Lesson l1 = new Lesson("monday", "14:00", "3", "name1", "teacher1","3");
        lessonRepository.save(l1);
        l1.setDay("tuesday");
        Lesson updatedLesson = lessonRepository.save(l1);
        assertThat(updatedLesson.getDay()=="tuesday");
    }


}
