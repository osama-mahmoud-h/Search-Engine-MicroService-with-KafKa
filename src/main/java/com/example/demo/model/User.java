package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @Field(type = FieldType.Text,name = "username")
    private String username;

    @Field(type = FieldType.Text,name = "email")
    private String email;

    @Field(type = FieldType.Text,name = "username")
    private String password;

    @Field(type = FieldType.Text,name = "image_url")
    private String imageUrl;

}
