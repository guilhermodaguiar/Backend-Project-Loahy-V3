package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.services.WishlistService;
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
@ContextConfiguration(classes = {WishlistController.class})
public class
WishlistControllerIntTest {

    @MockBean
    WishlistController wishlistController;

    @MockBean
    WishlistService wishlistService;

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldRetrieveAllWishlists() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/wishlists"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldRetrieveCorrectWishlist() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.get("/wishlists/1001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void shouldAssignProductToWishlist() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.put("/wishlists/1000/200"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldDeleteProductFromWishlist() throws Exception {
        this.mvc
                .perform(MockMvcRequestBuilders.delete("/wishlists/1001/200/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
