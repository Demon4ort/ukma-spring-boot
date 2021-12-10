package com.example.ukmaspringboot;

import com.example.ukmaspringboot.controllers.LessonController;
import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.repos.UserRepository;
import com.example.ukmaspringboot.service.LessonService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LessonController.class)
public class LessonControllerTest {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private LessonService lessonService;
    @Autowired
    private MockMvc mvc;
    @Test
    public void givenLessons_whenGetLessons_thenReturnJsonArray() throws Exception {

        given(lessonService.getLessons()).willReturn(List.of(new Lesson()));

        mvc.perform(MockMvcRequestBuilders.get("/lessons/lessons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void createLessonTest() throws Exception{
        Lesson lesson = new Lesson("name","year","teacher","3","time","ccc");


       mvc.perform(MockMvcRequestBuilders.post("/lessons/addLesson")
                       .contentType(MediaType.APPLICATION_JSON))
                       .andExpect(status().isBadRequest());

    }



}