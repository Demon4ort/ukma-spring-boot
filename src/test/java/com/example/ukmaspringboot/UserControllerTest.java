package com.example.ukmaspringboot;

import com.example.ukmaspringboot.controllers.LessonController;
import com.example.ukmaspringboot.controllers.UserController;
import com.example.ukmaspringboot.entities.Lesson;
import com.example.ukmaspringboot.entities.User;
import com.example.ukmaspringboot.repos.LessonRepository;
import com.example.ukmaspringboot.repos.UserRepository;
import com.example.ukmaspringboot.service.LessonService;
import com.example.ukmaspringboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private LessonRepository lessonRepository;
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mvc;
    @Test
    public void givenUsers_whenGetUsers_thenResponseOk() throws Exception {

        given(userService.getUsers()).willReturn(new LinkedList<User>());

        mvc.perform(MockMvcRequestBuilders.get("/users/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addUserTest() throws Exception{

    }
}
