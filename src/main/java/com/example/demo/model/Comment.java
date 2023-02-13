package com.example.demo.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class Comment {

    @Id
    private String id;

    @Field(type = FieldType.Text,name = "text")
    private String text;

    @Field(type = FieldType.Nested,name = "author")
    private User author;

}
