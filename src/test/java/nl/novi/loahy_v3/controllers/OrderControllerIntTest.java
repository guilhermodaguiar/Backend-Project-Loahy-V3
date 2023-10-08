package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.services.OrderService;
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
@ContextConfiguration(classes = {OrderController.class})
class OrderControllerIntTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    OrderService orderService;

    @MockBean
    OrderController orderController;


    @Test
    void shouldRetrieveAllOrders() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/orders"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldRetrieveCorrectOrder() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/orders/123"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldCreateOrder() throws Exception {

        this.mvc
                .perform(MockMvcRequestBuilders.post("/orders"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldDeleteOrder() throws Exception {

        this.mvc
                .perform(MockMvcRequestBuilders.delete("/orders/200"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }

}
