package com.example.mapping.service;

import com.example.mapping.entity.Customer;
import com.example.mapping.entity.Role;
import com.example.mapping.payload.RegisterCustomerDto;
import com.example.mapping.repository.CustomerRepository;
import com.example.mapping.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Customer createCustomer(RegisterCustomerDto customer) {
        Customer c = new Customer();
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setPassword(customer.getPassword());
        c.setCreatedAt(LocalDateTime.now());
        if(roleRepository.findByName("ROLE_USER") == null){
           Role r = createUserRole();
           roleRepository.save(r);
        }
        c.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return customerRepository.save(c);
    }

    private Role createUserRole(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }
}
