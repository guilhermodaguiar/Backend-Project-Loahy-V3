package nl.loahy_v3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.loahy_v3.model.Address;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    public Long id;
    public String streetName;
    public String houseNumber;
    public String houseNumberAddition;
    public String city;
    public String zipcode;
    public Long phoneNumber;


    public static AddressDto transferToAddressDto(Address address) {
        if (address == null) return null;

        var dto = new AddressDto();

        dto.id = address.getId();
        dto.streetName = address.getStreetName();
        dto.houseNumber = address.getHouseNumber();
        dto.houseNumberAddition = address.getHouseNumberAddition();
        dto.zipcode = address.getZipcode();
        dto.city = address.getCity();
        dto.phoneNumber = address.getPhoneNumber();

        return dto;
    }

    public AddressDto (Address address) {
        this.id = address.getId();
        this.streetName = address.getStreetName();
        this.houseNumber = address.getHouseNumber();
        this.houseNumberAddition = address.getHouseNumberAddition();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.phoneNumber = address.getPhoneNumber();
    }
}
