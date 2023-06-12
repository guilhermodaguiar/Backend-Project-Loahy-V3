package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.repositories.AddressRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Test
    @DisplayName("Should save the address when the address is not taken")
    void saveAddressWhenAddressIsNotTaken() {

        Address address = new Address();
        address.setStreetName("test");
        address.setHouseNumber("Test");
        address.setHouseNumberAddition("Test");
        address.setZipcode("Test");
        address.setCity("Test");
        address.setPhoneNumber(1L);

        when(addressRepository.save(address)).thenReturn(address);

        Address savedAddress = addressService.saveAddress(address);

        assertEquals(address, savedAddress);
    }

    @Test
    @DisplayName("Should update the address when the address exists")
    void updateAddressWhenAddressExists() {
        Address address1 = new Address();
        address1.setAddressId(1L);
        address1.setStreetName("test");
        address1.setHouseNumber("test");
        address1.setHouseNumberAddition("test");
        address1.setZipcode("test");
        address1.setCity("test");
        address1.setPhoneNumber(1L);
        when(addressRepository.findById(1L)).thenReturn(Optional.of(address1));

        address1.setCity("Amsterdam");
        addressService.updateAddress(1L, address1);

        verify(addressRepository).save(address1);

        assertThat(address1.getAddressId()).isEqualTo(1);
        assertThat(address1.getCity()).isEqualTo("Amsterdam");

    }

    @Test
    @DisplayName("Should throw an exception when the address does not exist")
    void updateAddressWhenAddressDoesNotExistThenThrowException() {
        Long addressId = 1L;
        Address address = new Address();

        assertThrows(RecordNotFoundException.class, () -> addressService.updateAddress(addressId, address));

        verify(addressRepository, times(1)).findById(addressId);
    }
}
