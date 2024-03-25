package nl.loahy_v3.controller;

import lombok.AllArgsConstructor;
import nl.loahy_v3.dto.AddressDto;
import nl.loahy_v3.dto.AddressInputDto;
import nl.loahy_v3.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> addressDtos = addressService.getAllAddresses();
        return ResponseEntity.ok().body(addressDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable("id") Long addressId) {
        AddressDto optionalAddress = addressService.getAddress(addressId);
        return ResponseEntity.ok().body(optionalAddress);
    }

    @GetMapping(value = "/zipcode")
    public ResponseEntity<List<AddressDto>> getAddressByZipcode(@RequestParam String zipcode) {
        List<AddressDto> dto = addressService.getAddressByZipcode(zipcode);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAddress(@PathVariable("id") Long id,
                                                @Valid @RequestBody AddressInputDto addressDto) {
        addressService.updateAddress(id, addressDto);
        return ResponseEntity.ok().body(addressDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}


