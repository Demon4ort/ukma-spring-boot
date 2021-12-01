package com.example.ukmaspringboot;

import com.example.ukmaspringboot.entities.Course;
import com.example.ukmaspringboot.repos.CourseRepository;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CourseRepositoryTest {
    private TestEntityManager entityManager;
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void testCourseAdding() {
        // given
        Course bd = new Course("DataBases", "Gulaeva N.M", "2");
        courseRepository.save(bd);

        assertThat(bd.getCourseId()!=null);
    }

    @Test
    public void testAllCoursesGetting(){
        Course cor1 = new Course("name1", "teacher1", "1");
        courseRepository.save(cor1);
        Course cor2 = new Course("name2", "teacher2", "2");
        courseRepository.save(cor2);
        Course cor3 = new Course("name3", "teacher3", "3");
        courseRepository.save(cor3);
        List<Course> courses = courseRepository.findAll();
        AssertionsForInterfaceTypes.assertThat(courses).hasSize(3).contains(cor1, cor2, cor3);
    }
}
