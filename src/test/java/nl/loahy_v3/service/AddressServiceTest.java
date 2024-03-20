package nl.loahy_v3.service;

import nl.loahy_v3.model.Address;
import nl.loahy_v3.repository.AddressRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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


//    @Test
//    @DisplayName("Should throw an exception when the address does not exist")
//    void updateAddressWhenAddressDoesNotExistThenThrowException() {
//        Long addressId = 1L;
//        Address address = new Address();
//
//        assertThrows(RecordNotFoundException.class, () -> addressService.updateAddress(addressId, address));
//
//        verify(addressRepository, times(1)).findById(addressId);
//    }
}
