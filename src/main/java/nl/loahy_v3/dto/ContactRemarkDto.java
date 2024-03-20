package nl.loahy_v3.dto;

import lombok.Getter;
import lombok.Setter;
import nl.loahy_v3.model.ContactRemark;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContactRemarkDto {

    @NotBlank(message = "contact name must not be blank")
    public String contactName;

    @Email(message = "invalid email address")
    @NotBlank(message = "email must not be blank")
    public String contactEmail;

    @NotNull(message = "contact phone must not be null")
    public Long contactPhone;
    public String contactOrganisation;

    @NotEmpty(message = "remark must not be empty")
    public String contactRemark;


    public ContactRemarkDto(ContactRemark contactRemark) {
        this.contactName = contactRemark.getContactName();
        this.contactEmail = contactRemark.getContactEmail();
        this.contactPhone = contactRemark.getContactPhone();
        this.contactOrganisation = contactRemark.getContactOrganisation();
        this.contactRemark = contactRemark.getContactRemark();
    }
}
