package com.example.mapping.service;

import com.example.mapping.entity.Customer;
import com.example.mapping.payload.RegisterCustomerDto;

public interface CustomerService {
    Customer createCustomer(RegisterCustomerDto customer);
}
