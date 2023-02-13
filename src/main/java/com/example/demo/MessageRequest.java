package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MessageRequest {
    private String message;
}
