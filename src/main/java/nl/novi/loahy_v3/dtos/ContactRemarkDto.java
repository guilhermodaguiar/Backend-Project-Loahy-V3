package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.ContactRemark;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ContactRemarkDto {

    @NotBlank(message = "contact name must not be blank")
    public String contactName;

    @Email(message = "check your email adress, it must not be blank")
    public String contactEmail;

    @NotNull
    public Long contactPhone;
    public String contactOrganisation;

    @NotEmpty(message = "remark must not be empty")
    public String contactRemark;

    public static ContactRemarkDto fromContact(ContactRemark contactRemark) {

        var contactDto = new ContactRemarkDto();

        contactDto.contactName = contactRemark.getContactName();
        contactDto.contactEmail = contactRemark.getContactEmail();
        contactDto.contactOrganisation = contactRemark.getContactOrganisation();
        contactDto.contactPhone = contactRemark.getContactPhone();
        contactDto.contactRemark = contactRemark.getContactRemark();

        return contactDto;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Long contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactOrganisation() {
        return contactOrganisation;
    }

    public void setContactOrganisation(String contactOrganisation) {
        this.contactOrganisation = contactOrganisation;
    }

    public String getContactRemark() {
        return contactRemark;
    }

    public void setContactRemark(String contactRemark) {
        this.contactRemark = contactRemark;
    }
}
