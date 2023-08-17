package com.example.demo.payload.request;

import com.example.demo.payload.response.UserResponceDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@Setter
@Getter
@ToString
public class PostRequestDto {
    private String id;
    private String text;
    private String[] images_urls;
    private String vedio_url;
    private String file_url;
    private Long comments_count;
    private Long likes_count;
    private UserResponceDto author;
}
