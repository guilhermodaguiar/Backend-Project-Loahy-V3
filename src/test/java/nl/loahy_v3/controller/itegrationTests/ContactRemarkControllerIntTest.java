package nl.loahy_v3.controller.itegrationTests;

import nl.loahy_v3.controller.ContactRemarkController;
import nl.loahy_v3.service.ContactRemarkService;
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
@ContextConfiguration(classes = {ContactRemarkController.class, ContactRemarkService.class})
public class ContactRemarkControllerIntTest {

    @MockBean
    ContactRemarkService contactRemarkService;

    @MockBean
    ContactRemarkController contactRemarkController;

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldRetrieveCorrectContactRemark() throws Exception {

        this.mvc
                .perform(MockMvcRequestBuilders.get("/remark/mvc@test.nl")
                        .content("{\"remarkId\":1,\"streetName\":\"Test\",\"houseNumber\":42,\"houseNumberAddition\":\"B\",\"city\":\"Almere\",\"zipcode\":\"3431PD\",\"phoneNumber\":\"0764537\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldCreateContactRemark() throws Exception {

        this.mvc
                .perform(MockMvcRequestBuilders.post("/remark")
                        .content("{\"contactName\":\"name\",\"contactEmail\":\"email@email.com\",\"contactPhone\":42,\"=contactOrganisation\":\"B\",\"contactRemark\":\"Almere\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldDeleteUser() throws Exception {

        this.mvc
                .perform(MockMvcRequestBuilders.delete("/remark/{id}", "test@test.nl"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
