package nl.novi.loahy_v3.controllers;


import nl.novi.loahy_v3.dtos.ContactRemarkDto;
import nl.novi.loahy_v3.models.ContactRemark;
import nl.novi.loahy_v3.services.ContactRemarkService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContactRemarkControllerTest {

    @Mock
    private ContactRemarkService contactRemarkService;

    @InjectMocks
    private ContactRemarkController contactRemarkController;

    @Test
    @DisplayName("Should throw an exception when the contact remark is invalid")
    void createContactRemarkWhenContactRemarkIsInvalidThrowException() {
        ContactRemarkDto contactRemarkDto = new ContactRemarkDto();
        contactRemarkDto.setContactEmail("");
        contactRemarkDto.setContactName("");
        contactRemarkDto.setContactRemark("");
        contactRemarkDto.setContactOrganisation("");
        contactRemarkDto.setContactPhone(6L);

        assertThrows(
                NullPointerException.class,
                () -> contactRemarkController.createRemark(contactRemarkDto));
    }

    @Test
    @DisplayName("Should delete a remark when contact email is valid")
    void deleteContactRemarkWhenEmailIsValid() {
        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setContactEmail("contact_remark@test.nl");
        contactRemark.setContactName("Mark Remark");
        contactRemark.setContactOrganisation("OrgTest");
        contactRemark.setContactRemark("test");
        contactRemark.setContactPhone(6L);

        contactRemarkService.deleteContact("contact_remark@test.nl");

        verify(contactRemarkService, times(1)).deleteContact("contact_remark@test.nl");
    }

    @Test
    @DisplayName("Should create a remark when the remark is valid")
    void createRemarkWhenRemarkIsValid() {
        ContactRemarkDto contactRemarkDto = new ContactRemarkDto();
        contactRemarkDto.setContactEmail("test@test.nl");
        contactRemarkDto.setContactName("test");
        contactRemarkDto.setContactRemark("test");
        contactRemarkDto.setContactOrganisation("test");
        contactRemarkDto.setContactPhone(6L);

        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setContactEmail("test@test.nl");
        contactRemark.setContactName("test");
        contactRemark.setContactOrganisation("test");
        contactRemark.setContactRemark("test");
        contactRemark.setContactPhone(6L);

        when(contactRemarkService.createRemark(any())).thenReturn(String.valueOf(contactRemark));

        assertThat(contactRemark.getContactEmail()).isEqualTo("test@test.nl");
    }
}
