package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends ElasticsearchRepository<Post,String> {

     Optional<Post> findById(String id);

     Post save(Post post);

     //List<Post>saveAll(List<Post> posts);

     List<Post> findAll();
}
