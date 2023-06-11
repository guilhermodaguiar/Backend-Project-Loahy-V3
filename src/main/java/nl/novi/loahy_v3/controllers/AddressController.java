package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.AddressDto;
import nl.novi.loahy_v3.dtos.AddressInputDto;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;


    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<AddressDto>> getAllAddresses() {

        List<AddressDto> addressDtos = addressService.getAllAddresses();

        return ResponseEntity.ok().body(addressDtos);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable("id") Long addressId) {

        AddressDto optionalAddress = addressService.getAddress(addressId);


        return ResponseEntity.ok().body(optionalAddress);
    }


    @PostMapping
    public AddressDto saveAddress(@RequestBody AddressInputDto dto) {

        var address = addressService.saveAddress(dto.toAddress());

        return AddressDto.transferToAddressDto(address);
    }

    @PutMapping("/update/{id}")
    public AddressDto updateAddress(@PathVariable("id") Long addressId,
                                  @RequestBody Address address) {
        addressService.updateAddress(addressId, address);

        return AddressDto.transferToAddressDto(address);
    }
}


