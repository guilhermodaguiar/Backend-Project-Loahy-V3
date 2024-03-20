package nl.loahy_v3.record;

import lombok.Builder;

@Builder
public record AddressRequest(
        Long id,
        String streetName,
        String houseNumber,
        String houseNumberAddition,
        String zipcode,
        String city,
        Long phoneNumber) {
}
