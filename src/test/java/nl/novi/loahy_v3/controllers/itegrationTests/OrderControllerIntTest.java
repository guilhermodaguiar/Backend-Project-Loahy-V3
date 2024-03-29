package nl.novi.loahy_v3.controllers.itegrationTests;

import nl.novi.loahy_v3.controllers.OrderController;
import nl.novi.loahy_v3.services.OrderService;
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
                .perform(MockMvcRequestBuilders.get("/orders/{id}", 123))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldCreateOrder() throws Exception {

        this.mvc
                .perform(MockMvcRequestBuilders.post("/orders")
                        .content("{\"orderId\":1,\"productList\":\"Test\",\"comment\":true,\"addressId\":5000,\"orderDate\":24091983}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldDeleteOrder() throws Exception {

        this.mvc
                .perform(MockMvcRequestBuilders.delete("/orders/{id}", 200))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
