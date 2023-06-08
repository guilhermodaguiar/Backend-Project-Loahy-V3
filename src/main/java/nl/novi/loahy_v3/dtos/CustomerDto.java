package nl.novi.loahy_v3.dtos;
import nl.novi.loahy_v3.models.Customer;

public class CustomerDto {

    public Long customerId;
    public String customerStreetName;
    public String customerHouseNumber;
    public String customerHouseNumberAddition;
    public String customerCity;
    public String customerZipcode;
    public Long customerPhone;



    public static CustomerDto transferToCustomerDto(Customer customer) {
        if (customer == null) return null;

        var dto = new CustomerDto();

        dto.customerId = customer.getCustomerId();
        dto.customerStreetName = customer.getCustomerStreetName();
        dto.customerHouseNumber = customer.getCustomerHouseNumber();
        dto.customerHouseNumberAddition = customer.getCustomerHouseNumberAddition();
        dto.customerCity = customer.getCustomerCity();
        dto.customerZipcode = customer.getCustomerZipcode();
        dto.customerPhone = customer.getCustomerPhone();

        return dto;
    }
}
