package nl.novi.loahy_v3.dtos;

import lombok.Getter;
import nl.novi.loahy_v3.models.Address;


@Getter
public class AddressDto {

    public Long addressId;
    public String streetName;

    public String houseNumber;
    public String houseNumberAddition;

    public String city;

    public String zipcode;

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
