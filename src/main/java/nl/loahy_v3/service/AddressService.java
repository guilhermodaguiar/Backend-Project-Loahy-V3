package nl.loahy_v3.service;

import lombok.AllArgsConstructor;
import nl.loahy_v3.dto.AddressDto;
import nl.loahy_v3.dto.AddressInputDto;
import nl.loahy_v3.exceptions.RecordNotFoundException;
import nl.loahy_v3.mapper.AddressMapper;
import nl.loahy_v3.model.Address;
import nl.loahy_v3.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import static nl.loahy_v3.mapper.AddressMapper.fromAddress;


@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<AddressDto> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(AddressMapper::fromAddress)
                .toList();
    }


    public AddressDto getAddress(Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            return fromAddress(address.get());
        } else {
            throw new RecordNotFoundException("Address bestaat niet..");
        }
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
        }
        addressRepository.deleteById(id);
    }
}



