package nl.loahy_v3.mapper;

import nl.loahy_v3.dto.AddressDto;
import nl.loahy_v3.model.Address;

public class AddressMapper {
    public static AddressDto fromAddress(Address address) {
        return new AddressDto(address);
    }
}
