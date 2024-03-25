package nl.loahy_v3.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "remarks")
public class ContactRemark {

    @Id
    @GeneratedValue(generator = "sequence_generator")
    @GenericGenerator(
            name = "sequence_generator2",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "remark_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "45"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long contactId;
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
