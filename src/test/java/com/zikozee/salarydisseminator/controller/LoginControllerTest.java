package com.zikozee.salarydisseminator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @InjectMocks
    LoginController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void showMyLoginPage() throws Exception {
        mockMvc.perform(get("/showMyLoginPage"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    void loginError() throws Exception {
        mockMvc.perform(get("/login-error.html"))
                .andExpect(model().attributeExists("loginError"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
}