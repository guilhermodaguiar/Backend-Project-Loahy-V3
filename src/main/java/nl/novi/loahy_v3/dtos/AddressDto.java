package nl.novi.loahy_v3.dtos;

import nl.novi.loahy_v3.models.Address;

import javax.validation.constraints.NotNull;

public class AddressDto {

    public Long addressId;
    @NotNull
    public String streetName;

    @NotNull
    public String houseNumber;
    public String houseNumberAddition;
    @NotNull
    public String city;
    @NotNull
    public String zipcode;
    @NotNull
    public Long phoneNumber;


    public static AddressDto transferToAddressDto(Address address) {
        if (address == null) return null;

        var dto = new AddressDto();

        dto.addressId = address.getAddressId();
        dto.streetName = address.getStreetName();
        dto.houseNumber = address.getHouseNumber();
        dto.houseNumberAddition = address.getHouseNumberAddition();
        dto.zipcode = address.getZipcode();
        dto.city = address.getCity();
        dto.phoneNumber = address.getPhoneNumber();

        return dto;
    }
}
