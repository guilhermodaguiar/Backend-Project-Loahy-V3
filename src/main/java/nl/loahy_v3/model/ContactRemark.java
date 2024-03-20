package nl.loahy_v3.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "remarks")
public class ContactRemark {

    @Id
    private Long id;
    private String contactEmail;
    private String contactName;
    private Long contactPhone;
    private String contactOrganisation;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String contactRemark;

    public ContactRemark(String contactName, String contactEmail, Long contactPhone, String contactOrganisation, String contactRemark) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactOrganisation = contactOrganisation;
        this.contactRemark = contactRemark;
    }
}
