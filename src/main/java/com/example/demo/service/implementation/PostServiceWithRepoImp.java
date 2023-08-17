package com.example.demo.service.implementation;

import com.example.demo.mappers.PostMapper;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.payload.request.PostRequestDto;
import com.example.demo.payload.response.PostResponceDto;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostServiceWithRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceWithRepoImp implements PostServiceWithRepo {
    public final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public Post save( PostRequestDto postDto) {
        Post post = postMapper.mapRequestDtoToPost(postDto);
        return postRepository.save(post);
    }


    private Post findPostById(String id){
       Optional<Post> post =  postRepository.findById(id);
       if(post.isEmpty()){
           return null;
       }
        return postRepository.findById(id).get();
    }

    //add comment
    public Post addCommentToPost(String postId , Comment comment){
        Post savedPost = findPostById(postId);
        savedPost.getComments().add(comment);
        return postRepository.save(savedPost);
    }

    @Override
    public List<Comment> getAllCommentsOnPost(final String postId) {
        Post savedPost = findPostById(postId);
        return savedPost.getComments();
    }

    @Override
    public PostResponceDto getPost(String postId) {
        Post savedPost = findPostById(postId);
        PostResponceDto postResponceDto = postMapper.mapPostToResponseDto(savedPost);
        return postResponceDto;
    }

    @Override
    public List<PostResponceDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostResponceDto> postResponceDtos = posts.stream().map(post -> postMapper.mapPostToResponseDto(post)).collect(Collectors.toList());
        return postResponceDtos;
    }

}
