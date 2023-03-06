package nl.novi.loahy_v3.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "about-company")
public class CompanyInfo {

    @Id
    public String name;


    public String information;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String aboutLoahy) {
        this.information = aboutLoahy;
    }
}
