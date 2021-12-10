package com.example.ukmaspringboot;

import com.example.ukmaspringboot.controllers.LoginController;
import com.example.ukmaspringboot.controllers.UserController;
import com.example.ukmaspringboot.repos.LessonRepository;
import com.example.ukmaspringboot.repos.UserRepository;
import com.example.ukmaspringboot.service.LoginService;
import com.example.ukmaspringboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private LessonRepository lessonRepository;
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService userService;
    @MockBean
    private LoginService loginService;

    @Test
    public void registrationTest() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/registration")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
