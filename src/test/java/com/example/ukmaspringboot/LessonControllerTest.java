package com.example.ukmaspringboot;

import com.example.ukmaspringboot.controllers.LessonController;
import com.example.ukmaspringboot.entities.Course;
import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LessonController.class)
public class LessonControllerTest {
    @MockBean
    private LessonController lessonController;
    @Autowired
    private MockMvc mvc;
    @Test
    public void givenLessons_whenGetLessons_thenReturnJsonArray() throws Exception{

        Course cor1 = new Course("name1", "teacher1", "1");
        Lesson lesson = new Lesson("Monday", "12:00", "3", cor1 );


        List<Lesson> allLessons = Arrays.asList(lesson);


        given(lessonController.getAllLessons()).willReturn(allLessons);

        mvc.perform(MockMvcRequestBuilders.get("/lessons/lessons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

//    @Test
//    public void givenRegistrationUri_whenMockMVC_thenStatusIsOk() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/registration"))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//    }

}
