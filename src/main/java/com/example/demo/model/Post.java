package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.*;

@Data
@ToString
@AllArgsConstructor

@Document(indexName = "postindex")
public class Post {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "text")
    private String text;

    @Field(type = FieldType.Text,name = "vedio_url")
    private String vedio_url;

    @Field(type = FieldType.Text,name = "images_urls")
    private Set<String> images_urls ;

    @Field(type = FieldType.Long,name = "likes_count")
    private Long likes_count;

    @Field(type = FieldType.Nested,name = "comments")
    private List<Comment> comments;

    @Field(type = FieldType.Nested,name = "author")
    private User author;

    public Post() {
        this.images_urls = new HashSet<>();
        this.comments = new ArrayList<>();
        this.likes_count = 0l;
    }
}