package com.rag.customer.service;

import com.rag.customer.service.model.CustomerDTO;

public interface CustomerService {
    public CustomerDTO getCustomerById(Long id);
}
