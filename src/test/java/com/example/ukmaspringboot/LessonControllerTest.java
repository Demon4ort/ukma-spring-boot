package com.example.ukmaspringboot;

import com.example.ukmaspringboot.controllers.LessonController;
import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.login.UserData;
import com.example.ukmaspringboot.repos.LessonRepository;
import com.example.ukmaspringboot.service.LessonService;
import com.example.ukmaspringboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(LessonController.class)
public class LessonControllerTest {
//    @MockBean
  // private LessonController lessonController;
//    @MockBean
//   private WebSecurityConfig wsc;
//    @MockBean
//    private UserData ud;
    @MockBean
    private CustomUserDetailsService cudf;
//    @MockBean
//    private LessonRepository lessonRepository;

    @MockBean
    private LessonService lessonService;
    @Autowired
    private MockMvc mvc;
    @Test
    public void givenLessons_whenGetLessons_thenReturnJsonArray() throws Exception{

        given(lessonService.getLessons()).willReturn( new LinkedList<Lesson>());

        mvc.perform(MockMvcRequestBuilders.get("/lessons/lessons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
              //  .andExpect(jsonPath("$", hasSize(1)));
    }


}