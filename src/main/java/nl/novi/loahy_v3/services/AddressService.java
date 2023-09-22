package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.AddressDto;
import nl.novi.loahy_v3.dtos.AddressInputDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.loahy_v3.dtos.AddressDto.transferToAddressDto;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


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

    public void updateAddress(Long id, AddressInputDto addressDto) {

        if (!addressRepository.existsById(id)) {
            throw new RecordNotFoundException("Address bestaat niet..");
        } else {

            Address address = addressRepository.findById(id).get();

            address.setStreetName(addressDto.getStreetName());
            address.setHouseNumber(addressDto.getHouseNumber());
            address.setHouseNumberAddition(addressDto.getHouseNumberAddition());
            address.setZipcode(addressDto.getZipcode());
            address.setCity(addressDto.getCity());
            address.setPhoneNumber(addressDto.getPhoneNumber());

            addressRepository.save(address);
        }
    }

    public void deleteAddress(@RequestBody Long id) {
        if (!addressRepository.existsById(id)) {
            throw new RecordNotFoundException("Address bestaat niet..");
        } else {
            addressRepository.deleteById(id);
        }
    }
}



