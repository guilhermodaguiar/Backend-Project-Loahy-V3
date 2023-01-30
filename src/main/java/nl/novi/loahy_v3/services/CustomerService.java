package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.CustomerDto;
import nl.novi.loahy_v3.dtos.CustomerInputDto;
import nl.novi.loahy_v3.models.Customer;
import nl.novi.loahy_v3.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.loahy_v3.dtos.CustomerDto.transferToCustomerDto;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getCustomers() {
        List<CustomerDto> collection = new ArrayList<>();
        List<Customer> list = customerRepository.findAll();
        for (Customer customer : list) {
            collection.add(transferToCustomerDto(customer));
        }
        return collection;
    }


    public CustomerDto createCustomer(CustomerDto Dto) {

        Customer newCustomer = transferToCustomer(Dto);

        customerRepository.save(newCustomer);

        return transferToCustomerDto(newCustomer);

    }


    public CustomerDto getCustomer(Long customerId) {
        CustomerDto dto = new CustomerDto();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            dto = transferToCustomerDto(customer.get());
        } else {
            throw new CustomerNotFoundException(customerId);
        }
        return dto;
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public CustomerDto updateCustomer(Long customerId, CustomerInputDto inputDto) {
        if (customerRepository.findById(customerId).isPresent()) {

            Customer customer = customerRepository.findById(customerId).get();

            Customer customer1 = transferToCustomer2(inputDto);
            customer1.setCustomerId(customer.getCustomerId());

            customerRepository.save(customer1);

            return transferToCustomerDto(customer1);
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public Customer transferToCustomer(CustomerDto Dto) {

        var customer = new Customer();

        customer.setCustomerFirstName(Dto.getCustomerFirstName());
        customer.setCustomerLastName(Dto.getCustomerLastName());
        customer.setCustomerStreetName(Dto.getCustomerStreetName());
        customer.setCustomerHouseNumber(Dto.getCustomerHouseNumber());
        customer.setCustomerHouseNumberAddition(Dto.getCustomerHouseNumberAddition());
        customer.setCustomerZipcode(Dto.getCustomerZipcode());
        customer.setCustomerCity(Dto.getCustomerCity());
        customer.setCustomerPhone(Dto.getCustomerPhone());
        return customer;
    }

    public Customer transferToCustomer2(CustomerInputDto Dto) {

        var customer = new Customer();

        customer.setCustomerFirstName(Dto.getCustomerFirstName());
        customer.setCustomerLastName(Dto.getCustomerLastName());
        customer.setCustomerStreetName(Dto.getCustomerStreetName());
        customer.setCustomerHouseNumber(Dto.getCustomerHouseNumber());
        customer.setCustomerHouseNumberAddition(Dto.getCustomerHouseNumberAddition());
        customer.setCustomerCity(Dto.getCustomerCity());
        customer.setCustomerZipcode(Dto.getCustomerZipcode());
        customer.setCustomerPhone(Dto.getCustomerPhone());
        return customer;
    }



}


