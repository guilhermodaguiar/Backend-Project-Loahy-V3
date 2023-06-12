package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.AddressDto;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.repositories.AddressRepository;
import nl.novi.loahy_v3.services.AddressService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressControllerTest {

    @Mock
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressController addressController;

    @Test@DisplayName("Should save address when address is valid")
    void saveAddressWhenAddressIsValid() {
        Address address = new Address();
        address.setStreetName("Test");
        address.setHouseNumber("Test");
        address.setHouseNumberAddition("Test");
        address.setZipcode("Test");
        address.setCity("Test");
        address.setPhoneNumber(1L);

        addressRepository.save(address);

        assertThat(address.getStreetName()).isEqualTo("Test");
    }

    @Test
    @DisplayName("Should return the address when the id is valid")
    void getPersonWhenIdIsValid() {
        Address address = new Address();
        address.setAddressId(1L);
        address.setStreetName("testerstraat");
        address.setHouseNumber("35");
        address.setHouseNumberAddition("c");
        address.setZipcode("1111AA");
        address.setCity("Utrecht");
        address.setPhoneNumber(1L);

        when(addressService.getAddress(1L)).thenReturn(AddressDto.transferToAddressDto(address));

        AddressDto result = addressController.getAddress(1L).getBody();

        assertNotNull(result);
        assertEquals(1L, result.addressId);
        assertEquals("testerstraat", result.streetName);
        assertEquals("35", result.houseNumber);
        assertEquals("c", result.houseNumberAddition);
        assertEquals("1111AA", result.zipcode);
        assertEquals("Utrecht", result.city);
        assertEquals(1L, result.phoneNumber);

    }
}
