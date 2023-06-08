package nl.novi.loahy_v3.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "customer_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "5005"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column
    private Long customerId;

    @Column
    private String customerStreetName;
    @Column
    private String customerHouseNumber;
    @Column
    private String customerHouseNumberAddition;
    @Column
    private String customerCity;
    @Column
    private String customerZipcode;
    @Column
    private Long customerPhone;





    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    public String getCustomerStreetName() {
        return customerStreetName;
    }

    public void setCustomerStreetName(String customerStreetName) {
        this.customerStreetName = customerStreetName;
    }

    public String getCustomerHouseNumber() {
        return customerHouseNumber;
    }

    public void setCustomerHouseNumber(String customerHouseNumber) {
        this.customerHouseNumber = customerHouseNumber;
    }

    public String getCustomerHouseNumberAddition() {
        return customerHouseNumberAddition;
    }

    public void setCustomerHouseNumberAddition(String customerHouseNumberAdd) {
        this.customerHouseNumberAddition = customerHouseNumberAdd;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerZipcode() {
        return customerZipcode;
    }

    public void setCustomerZipcode(String customerZipcode) {
        this.customerZipcode = customerZipcode;
    }

    public Long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Long customerPhone) {
        this.customerPhone = customerPhone;
    }


    public Customer() {
    }
}
