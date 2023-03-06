package nl.novi.loahy_v3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactRemarkTest {

    @Test
    @DisplayName("Should set the contact email")
    void setEmail() {
        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setContactEmail("test@test.nl");
        assertEquals("test@test.nl", contactRemark.getContactEmail());
    }

    @Test
    @DisplayName("Should set the contact name")
    void setName() {
        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setContactName("Test name");
        assertEquals("Test name", contactRemark.getContactName());
    }


    @Test
    @DisplayName("Should set the contact remark")
    void setRemark() {
        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setContactRemark("This is a remark");
        assertEquals("This is a remark", contactRemark.getContactRemark());
    }

    @Test
    @DisplayName("Should set the contact phone number")
    void setPhone() {
        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setContactPhone(6L);
        assertEquals(6L, contactRemark.getContactPhone());
    }

    @Test
    @DisplayName("Should set the contact name")
    void setOrganisation() {
        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setContactOrganisation("Org Test");
        assertEquals("Org Test", contactRemark.getContactOrganisation());
    }

}
