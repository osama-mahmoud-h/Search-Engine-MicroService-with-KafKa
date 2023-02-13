package com.example.demo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostResponceDto {
    private Long id;
    private String text;
    private String image_url;
    private String vedio_url;
    private Long likes;
    private Long comments_count;
    private UserResponceDto author;
}
