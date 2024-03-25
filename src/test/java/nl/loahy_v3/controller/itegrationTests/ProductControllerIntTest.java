package nl.loahy_v3.controller.itegrationTests;

import nl.loahy_v3.controller.ProductController;
import nl.loahy_v3.service.ProductService;
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
@ContextConfiguration(classes = {ProductController.class})
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
                .perform(MockMvcRequestBuilders.get("/product"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldRetrieveCorrectProduct() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/product/200"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldCreateProduct() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.post("/product")
                        .content("{\"productId\":1,\"productName\":\"Dit\",\"productDescription\":\"Dit is " +
                                "een heel mooi product\",\"productPrice\":1}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void shouldUpdateProduct() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.put("/product/200")
                        .content("{\"productId\":1,\"productName\":\"Dit\",\"productDescription\":\"Dit is " +
                                "een heel mooi product\",\"productPrice\":1}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldDeleteCorrectProduct() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.delete("/product/{id}", 200))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
