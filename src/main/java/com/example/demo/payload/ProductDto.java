package com.example.demo.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;

    private String name;

    private Double price;

    private Integer quantity;

    private String category;

    private String description;

    private String manufacturer;
}
