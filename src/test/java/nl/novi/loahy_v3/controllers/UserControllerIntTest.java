package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.JwtUtil;
import nl.novi.loahy_v3.services.CustomUserDetailsService;
import nl.novi.loahy_v3.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(excludeAutoConfiguration = {SecurityAutoConfiguration.class})
@ContextConfiguration(classes = {UserController.class})
public class UserControllerIntTest {

    @MockBean
    CustomUserDetailsService customUserDetailsService;

    @MockBean
    UserService userService;

    @MockBean
    JwtUtil jwtUtil;

    @Autowired
    private MockMvc mvc;


    @Test
    void shouldRetrieveCorrectUser() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/users/mvc@test.nl"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldUpdateCorrectUsersPassword() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.patch("/users/mvc@test.nl"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
