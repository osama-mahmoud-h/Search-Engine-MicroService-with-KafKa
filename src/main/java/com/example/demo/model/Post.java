package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Document(indexName = "postindex")
public class Post {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "text")
    private String text;

    @Field(type = FieldType.Text,name = "vedio_url")
    private String vedio_url;

    @Field(type = FieldType.Text,name = "image_url")
    private String images_url ;

    @Field(type = FieldType.Long,name = "likes")
    private Long likes;

    @Field(type = FieldType.Nested,name = "comments")
    private Set<Comment> comments;

    @Field(type = FieldType.Nested,name = "author")
    private User author;

}