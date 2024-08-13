package com.example.mapping.payload;

import com.example.mapping.entity.Address;
import com.example.mapping.entity.Order;
import com.example.mapping.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RegisterCustomerDto {
    @NotNull(message = "name is mandatory")
    private String name;
    @NotNull(message = "email is mandatory")
    @Email(message = "invalid email")
    private String email;
    @NotNull(message = "password is mandatory")
    private String password;
}
