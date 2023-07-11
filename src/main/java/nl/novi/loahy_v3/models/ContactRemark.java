package nl.novi.loahy_v3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "remarks")
public class ContactRemark {
    @Id
    @Column(nullable = false)
    @Email
    private String contactEmail;
    @Column(nullable = false)
    @NotBlank
    private String contactName;

    @Column(nullable = false)
    private Long contactPhone;
    @Column
    @NotBlank
    private String contactOrganisation;

    @Column(columnDefinition = "TEXT", nullable = false)
    @NotBlank
    private String contactRemark;


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
