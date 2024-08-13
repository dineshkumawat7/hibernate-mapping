package com.example.mapping.controller;

import com.example.mapping.entity.Customer;
import com.example.mapping.payload.RegisterCustomerDto;
import com.example.mapping.service.CustomerService;
import com.example.mapping.utils.ApiResponse;
import com.example.mapping.utils.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    ApiResponse apiResponse;
    @Autowired
    ErrorResponse errorResponse;
    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody RegisterCustomerDto customer){
        try{
            Customer createdCustomer = customerService.createCustomer(customer);
            apiResponse.setStatusCode(HttpStatus.CREATED.value());
            apiResponse.setStatus("success");
            apiResponse.setMessage("New customer registered");
            apiResponse.setData(customer);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }catch (Exception e){
            errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorResponse.setStatus("error");
            errorResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
