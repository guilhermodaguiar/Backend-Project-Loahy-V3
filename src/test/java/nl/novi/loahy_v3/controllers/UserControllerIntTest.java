package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.services.UserService;
import nl.novi.loahy_v3.JwtUtil;
import nl.novi.loahy_v3.LoahyV3Application;
import nl.novi.loahy_v3.services.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = LoahyV3Application.class)
public class UserControllerIntTest {

    @MockBean
    CustomUserDetailsService customUserDetailsService;

    @MockBean
    UserService userService;

    @MockBean
    JwtUtil jwtUtil;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void shouldRetrieveCorrectUser() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/users/mvc@test.nl"))
                .andDo(MockMvcResultHandlers.print());
    }
}
