package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.LoahyV3Application;
import nl.novi.loahy_v3.services.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@ContextConfiguration(classes={LoahyV3Application.class})
class AddressControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AddressService addressService;

    @Test
    void shouldRetrieveCorrectAddress() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/address/1001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}