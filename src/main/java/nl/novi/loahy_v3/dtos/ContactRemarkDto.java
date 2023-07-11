package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.ContactRemark;

public class ContactRemarkDto {


    public String contactName;

    public String contactEmail;

    public Long contactPhone;
    public String contactOrganisation;

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
