package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.CustomerDto;
import nl.novi.loahy_v3.dtos.CustomerInputDto;
import nl.novi.loahy_v3.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CustomerDto>> getCustomers() {

        List<CustomerDto> customerDtos = customerService.getCustomers();

        return ResponseEntity.ok().body(customerDtos);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long customerId) {

        CustomerDto optionalCustomer = customerService.getCustomer(customerId);


        return ResponseEntity.ok().body(optionalCustomer);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto Dto) {
        CustomerDto customerDto1 = customerService.createCustomer(Dto);

        return ResponseEntity.created(null).body(customerDto1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long customerId,
                                                 @RequestBody CustomerInputDto inputDto) {

        CustomerDto customerDto = customerService.updateCustomer(customerId, inputDto);

        return ResponseEntity.ok().body(customerDto);
    }


    @DeleteMapping(value = "{id}")
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}


