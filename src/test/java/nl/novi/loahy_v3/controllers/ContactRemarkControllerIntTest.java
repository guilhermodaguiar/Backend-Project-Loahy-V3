package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.ContactRemarkDto;
import nl.novi.loahy_v3.dtos.OrderDto;
import nl.novi.loahy_v3.services.ContactRemarkService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
@ContextConfiguration(classes = {ContactRemarkController.class})
public class ContactRemarkControllerIntTest {

    @MockBean
    ContactRemarkService contactRemarkService;

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldRetrieveCorrectContactRemark() throws Exception {


        this.mvc
                .perform(MockMvcRequestBuilders.get("/users/mvc@test.nl"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
