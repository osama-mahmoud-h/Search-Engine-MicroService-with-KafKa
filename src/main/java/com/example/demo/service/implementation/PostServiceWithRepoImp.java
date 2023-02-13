package com.example.demo.service.implementation;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.payload.response.PostResponceDto;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostServiceWithRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceWithRepoImp implements PostServiceWithRepo {
    public final PostRepository postRepository;

//    public Post save(Post post) {
//        return postRepository.save(post);
//    }

//    public List<Post>saveAll(List<Post> posts){
//        return postRepository.saveAll(posts);
//    }

    @Override
    public Post save(PostResponceDto postResponceDto) {

        Post post = mapPostResponseDtoToPost(postResponceDto);
        Post saved = postRepository.save(post);
        System.out.println("saved post: "+post);
        return saved;
    }

    public Post findPostById(String id){
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
    public Set<Comment> getAllCommentsOnPost(final String postId) {
        Post savedPost = findPostById(postId);
        return savedPost.getComments();
    }

    @Override
    public Post mapPostResponseDtoToPost(PostResponceDto postResponceDto) {
        Post post = new Post();
        post.setId(postResponceDto.getId().toString());
        post.setText(postResponceDto.getText());
        post.setLikes(postResponceDto.getLikes());
        post.setImages_url(postResponceDto.getImage_url());
        post.setVedio_url(postResponceDto.getVedio_url());

        User author = new User();

        author.setId(postResponceDto.getAuthor().getId().toString());
        author.setUsername(postResponceDto.getAuthor().getUsername());
        author.setEmail(postResponceDto.getAuthor().getEmail());
        author.setImageUrl(postResponceDto.getAuthor().getImage_url());

        post.setAuthor(author);


        return post;
    }

}
