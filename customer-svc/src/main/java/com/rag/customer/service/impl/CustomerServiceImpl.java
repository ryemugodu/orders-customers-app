package com.rag.customer.service.impl;

import com.rag.customer.data.Customer;
import com.rag.customer.repository.AddressRepository;
import com.rag.customer.repository.CustomerRepository;
import com.rag.customer.service.CustomerService;
import com.rag.customer.service.model.AddressDTO;
import com.rag.customer.service.model.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final AddressRepository addressRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return customer != null ?
                CustomerDTO.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .email(customer.getEmail())
                        .phone(customer.getPhone())
                        .address(AddressDTO.builder()
                                .id(customer.getAddress().getId())
                                .street(customer.getAddress().getStreet())
                                .city(customer.getAddress().getCity())
                                .state(customer.getAddress().getState())
                                .zip(customer.getAddress().getZip())
                                .country(customer.getAddress().getCountry())
                                .build())
                        .build()
                : null;
    }
}
