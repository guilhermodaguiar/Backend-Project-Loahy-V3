package nl.novi.loahy_v3.dtos;
import nl.novi.loahy_v3.models.Customer;

public class CustomerDto {

    public Long customerId;
    public String customerFirstName;
    public String customerLastName;
    public String customerStreetName;
    public String customerHouseNumber;
    public String customerHouseNumberAddition;
    public String customerCity;
    public String customerZipcode;
    public Long customerPhone;



    public static CustomerDto transferToCustomerDto(Customer customer) {

        var customerDto = new CustomerDto();

        customerDto.customerId = customer.getCustomerId();
        customerDto.customerFirstName = customer.getCustomerFirstName();
        customerDto.customerLastName = customer.getCustomerLastName();
        customerDto.customerStreetName = customer.getCustomerStreetName();
        customerDto.customerHouseNumber = customer.getCustomerHouseNumber();
        customerDto.customerHouseNumberAddition = customer.getCustomerHouseNumberAddition();
        customerDto.customerCity = customer.getCustomerCity();
        customerDto.customerZipcode = customer.getCustomerZipcode();
        customerDto.customerPhone = customer.getCustomerPhone();

        return customerDto;
    }



    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
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

    public void setCustomerHouseNumberAddition(String customerHouseNumberAddition) {
        this.customerHouseNumberAddition = customerHouseNumberAddition;
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
}
