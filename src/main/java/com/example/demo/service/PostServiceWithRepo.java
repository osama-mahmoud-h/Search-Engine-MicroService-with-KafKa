package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.payload.response.PostResponceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface PostServiceWithRepo {
    public Post save(PostResponceDto postResponceDto);

   // public List<Post> saveAll(List<Post> posts);

    public Post findPostById(String id);

    public Post addCommentToPost(String postId , Comment comment);

    public Set<Comment> getAllCommentsOnPost(final String postId);

    public Post mapPostResponseDtoToPost(PostResponceDto postResponceDto);
}
