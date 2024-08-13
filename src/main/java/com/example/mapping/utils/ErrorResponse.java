package com.example.mapping.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ErrorResponse {
    private Integer statusCode;
    private String status;
    private String message;
}
