package nl.novi.loahy_v3.dtos;

import lombok.Getter;
import lombok.Setter;
import nl.novi.loahy_v3.models.ContactRemark;

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

    public static ContactRemarkDto fromContact(ContactRemark contactRemark) {

        var contactDto = new ContactRemarkDto();

        contactDto.contactName = contactRemark.getContactName();
        contactDto.contactEmail = contactRemark.getContactEmail();
        contactDto.contactOrganisation = contactRemark.getContactOrganisation();
        contactDto.contactPhone = contactRemark.getContactPhone();
        contactDto.contactRemark = contactRemark.getContactRemark();

        return contactDto;
    }
}
