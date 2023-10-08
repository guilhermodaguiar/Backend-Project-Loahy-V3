package nl.novi.loahy_v3.controllers.itegrationTests;

import nl.novi.loahy_v3.controllers.AddressController;
import nl.novi.loahy_v3.services.AddressService;
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
@ContextConfiguration(classes = {AddressController.class})
class AddressControllerIntTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    AddressService addressService;


    @Test
    void shouldRetrieveCorrectAddresses() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/address"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldRetrieveCorrectAddress() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/address/1001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldUpdateCorrectAddress() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.put("/address/1001")
                        .content("{\"addressId\":1,\"streetName\":\"Test\",\"houseNumber\":42,\"houseNumberAddition\":\"B\",\"city\":\"Almere\",\"zipcode\":\"3431PD\",\"phoneNumber\":\"0764537\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldDeleteCorrectAddress() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.delete("/address/1001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}