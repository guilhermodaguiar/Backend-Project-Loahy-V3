package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.AddressDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.loahy_v3.dtos.AddressDto.transferToAddressDto;


@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDto> getAllAddresses() {
        List<AddressDto> collection = new ArrayList<>();
        List<Address> list = addressRepository.findAll();
        for (Address address : list) {
            collection.add(transferToAddressDto(address));
        }
        return collection;
    }


    public AddressDto getAddress(Long addressId) {
        AddressDto dto = new AddressDto();
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            dto = transferToAddressDto(address.get());
        } else {
            throw new RecordNotFoundException("Address bestaat niet..");
        }
        return dto;
    }


    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void updateAddress(Long id, Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(id);

        if (optionalAddress.isEmpty()) {
            throw new RecordNotFoundException("Address bestaat niet..");
        } else {

            Address address1 = optionalAddress.get();
            address1.setAddressId(address1.getAddressId());
            address1.setStreetName(address.getStreetName());
            address1.setHouseNumber(address.getHouseNumber());
            address1.setHouseNumberAddition(address.getHouseNumberAddition());
            address1.setZipcode(address.getZipcode());
            address1.setCity(address.getCity());
            address1.setPhoneNumber(address.getPhoneNumber());

            addressRepository.save(address1);
        }

    }
}


