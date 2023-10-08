package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.services.AddressService;
import nl.novi.loahy_v3.services.ProductService;
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
@ContextConfiguration(classes={ProductController.class})
public class ProductControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ProductService productService;

    @MockBean
    ProductController productController;

    @Test
    void shouldRetrieveAllProducts() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/products"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldRetrieveCorrectProduct() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/products/200"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldCreateProduct() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.post("/products"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldUpdateProduct() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.put("/products/200"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldDeleteCorrectProduct() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.delete("/products/200"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
