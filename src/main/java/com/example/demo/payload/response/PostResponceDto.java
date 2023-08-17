package com.example.demo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostResponceDto {
    private String id;
    private Date timestamp;
    private String text;
    private String[] images_urls;
    private String vedio_url;
    private String file_url;
    private Long comments_count;
    private Object author;
   // private byte myFeed;
   // private Map<Byte,Long> feeds;
}
