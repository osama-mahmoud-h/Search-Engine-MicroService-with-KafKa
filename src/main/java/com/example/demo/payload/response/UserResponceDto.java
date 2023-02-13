package com.example.demo.payload.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponceDto {
    private Long id;
    private String username;
    private String email;
    private String image_url;
}
