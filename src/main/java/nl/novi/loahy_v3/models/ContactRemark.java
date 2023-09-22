package nl.novi.loahy_v3.models;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Entity
@Table(name = "remarks")
public class ContactRemark {
    @Id
    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactName;

    @Column(nullable = false)
    private Long contactPhone;
    @Column
    private String contactOrganisation;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contactRemark;


    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactPhone(Long contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setContactOrganisation(String contactOrganisation) {
        this.contactOrganisation = contactOrganisation;
    }

    public void setContactRemark(String contactRemark) {
        this.contactRemark = contactRemark;
    }
}
