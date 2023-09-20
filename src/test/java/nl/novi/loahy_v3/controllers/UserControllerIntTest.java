package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.config.SpringSecurityConfig;
import nl.novi.loahy_v3.filters.JwtRequestFilter;
import nl.novi.loahy_v3.repositories.UserRepository;
import nl.novi.loahy_v3.services.CustomUserDetailsService;
import nl.novi.loahy_v3.services.UserService;
import nl.novi.loahy_v3.utils.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(UserController.class)
public class UserControllerIntTest {

    @MockBean
    UserService userService;

    @MockBean
    UserController userController;

    @MockBean
    UserRepository userRepository;


    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc =
                MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void shouldRetrieveCorrectUser() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/users/mvc@test.nl"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
