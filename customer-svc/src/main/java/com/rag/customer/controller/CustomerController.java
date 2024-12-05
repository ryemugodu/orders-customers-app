package com.rag.customer.controller;

import com.rag.customer.service.CustomerService;
import com.rag.customer.service.model.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String customerId) {
        var customer = customerService.getCustomerById(Long.valueOf(customerId));
        return ResponseEntity.ok(customer);
    }
}
