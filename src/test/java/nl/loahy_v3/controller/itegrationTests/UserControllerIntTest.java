package nl.loahy_v3.controller.itegrationTests;

import nl.loahy_v3.JwtUtil;
import nl.loahy_v3.controller.UserController;
import nl.loahy_v3.service.CustomUserDetailsService;
import nl.loahy_v3.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(excludeAutoConfiguration = {SecurityAutoConfiguration.class})
@ContextConfiguration(classes = {UserController.class, UserService.class})
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
                .perform(MockMvcRequestBuilders.get("/user/{id}", "mvc@test.nl")
                        .content("{\"email\":\"email@email.com\",\"password\":\"Dit44goed!\",\"userId\":10,\"firstName\":1,\"lastName\":2}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldUpdateCorrectUsersPassword() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.patch("/user/200")
                        .content("{\"email\":1,\"password\":\"Dit44goed!\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }


    @Test
    void shouldCreateCorrectUser() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.post("/user")
                        .content("{\"email\":\"email@email.com\",\"password\":\"Dit44goed!\",\"userId\":10,\"firstName\":1,\"lastName\":2}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
    }

    @Test
    void shouldDeleteUser() throws Exception {

        this.mvc
                .perform(MockMvcRequestBuilders.delete("/user/{id}", "test@test.nl"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
