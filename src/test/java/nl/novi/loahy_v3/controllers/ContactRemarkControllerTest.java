package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.ContactRemarkDto;
import nl.novi.loahy_v3.services.ContactRemarkService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContactRemarkControllerTest {

    @Mock
    private ContactRemarkService contactRemarkService;

    @InjectMocks
    private ContactRemarkController contactRemarkController;


    @Test
    @DisplayName("Should create a remark when the contact remark is valid")
    void createContactRemarkWhenContactRemarkIsInvalid() throws Exception {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        ContactRemarkDto remark = new ContactRemarkDto();
        remark.setContactName("test");
        remark.setContactEmail("test");
        remark.setContactPhone(1L);
        remark.setContactOrganisation("test");

        ResponseEntity<ContactRemarkDto> response = contactRemarkController.createRemark(remark);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }


    @Test
    @DisplayName("Should delete a remark when contact email is valid")
    void deleteContactRemarkWhenEmailIsValid() {
        ContactRemarkDto dto = new ContactRemarkDto();
        dto.setContactEmail("contact_remark@test.nl");
        dto.setContactName("Mark Remark");
        dto.setContactOrganisation("OrgTest");
        dto.setContactRemark("test");
        dto.setContactPhone(6L);

        contactRemarkService.deleteContact("contact_remark@test.nl");

        verify(contactRemarkService, times(1)).deleteContact("contact_remark@test.nl");
    }
}
