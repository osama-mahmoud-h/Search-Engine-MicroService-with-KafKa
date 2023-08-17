package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.payload.request.PostRequestDto;
import com.example.demo.payload.response.PostResponceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServiceWithRepo {
    public Post save(PostRequestDto postResponceDto);

    public Post addCommentToPost(String postId , Comment comment);

    public List<Comment> getAllCommentsOnPost(final String postId);

    public PostResponceDto getPost(String postId);

    public List<PostResponceDto> getAllPosts();

}
