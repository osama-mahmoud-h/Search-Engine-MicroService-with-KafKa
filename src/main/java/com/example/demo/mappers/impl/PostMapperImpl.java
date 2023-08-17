package com.example.demo.mappers.impl;

import com.example.demo.mappers.PostMapper;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.payload.request.PostRequestDto;
import com.example.demo.payload.response.PostResponceDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class PostMapperImpl implements PostMapper {
    @Override
    public Post mapRequestDtoToPost(PostRequestDto postRequestDto){
        Post post = new Post();
        post.setId(postRequestDto.getId().toString());
        post.setText(postRequestDto.getText());
        post.setImages_urls(new HashSet<>(Arrays.asList(postRequestDto.getImages_urls())));
        post.setVedio_url(postRequestDto.getVedio_url());

        User author = new User();

        author.setId(postRequestDto.getAuthor().getId().toString());
        author.setUsername(postRequestDto.getAuthor().getUsername());
        author.setEmail(postRequestDto.getAuthor().getEmail());
        author.setImageUrl(postRequestDto.getAuthor().getImage_url());

        post.setAuthor(author);
        return post;
    }

    @Override
    public PostResponceDto mapPostToResponseDto(Post post){
        PostResponceDto postResponceDto = new PostResponceDto();
        postResponceDto.setId(post.getId());
        postResponceDto.setText(post.getText());
        Set<String> imageSet = post.getImages_urls();
        postResponceDto.setImages_urls(imageSet.toArray(new String[imageSet.size()]));
        postResponceDto.setVedio_url(post.getVedio_url());

        User author = new User();

        author.setId(post.getAuthor().getId().toString());
        author.setUsername(post.getAuthor().getUsername());
        author.setEmail(post.getAuthor().getEmail());
        author.setImageUrl(post.getAuthor().getImageUrl());

        postResponceDto.setAuthor(author);
        return postResponceDto;
    }
//    @Override
//    public Post mapResponseDtoToPost(PostResponceDto postResponceDto) {
//        Post post = new Post();
//        post.setId(postResponceDto.getId().toString());
//        post.setText(postResponceDto.getText());
//        //post.setLikes(postResponceDto.);
//        //post.setImages_url(postResponceDto.getImage_url());
//        post.setVedio_url(postResponceDto.getVedio_url());
//
//        User author = new User();
//
//        author.setId(postResponceDto.getAuthor().getId().toString());
//        author.setUsername(postResponceDto.getAuthor().getUsername());
//        author.setEmail(postResponceDto.getAuthor().getEmail());
//        author.setImageUrl(postResponceDto.getAuthor().getImage_url());
//
//        post.setAuthor(author);
//
//
//        return post;
//    }
}
