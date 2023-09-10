package nl.novi.loahy_v3.models;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "address_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "5005"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column
    private Long addressId;

    @Column
    private String streetName;
    @Column
    private String houseNumber;
    @Column
    private String houseNumberAddition;
    @Column
    private String city;
    @Column
    private String zipcode;
    @Column
    private Long phoneNumber;


    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }


    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setHouseNumberAddition(String houseNumberAddition) {
        this.houseNumberAddition = houseNumberAddition;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Address() {
    }
}
