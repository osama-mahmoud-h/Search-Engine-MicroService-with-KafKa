package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.payload.request.PostRequestDto;
import com.example.demo.payload.response.PostResponceDto;
import com.example.demo.service.PostSearchService;
import com.example.demo.service.PostServiceWithRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostServiceWithRepo postServiceWithRepo;
    private final PostSearchService postSearchService;

    @PostMapping("/save")
    public ResponseEntity<Post>savePost(@RequestBody PostRequestDto postDto){
        return ResponseEntity
                .ok()
                .body(postServiceWithRepo.save(postDto));
    }

//    @PostMapping("/save-all")
//    public ResponseEntity<List<Post>>saveAllPosts(@RequestBody List<Post> posts){
//        return ResponseEntity
//                .ok()
//                .body(postServiceWithRepo.saveAll(posts));
//    }

    @GetMapping("/get/{postid}")
    public ResponseEntity<PostResponceDto> getPost(@PathVariable("postid") String postId){
        return ResponseEntity
                .ok()
                .body(postServiceWithRepo.getPost(postId));
    }

    @GetMapping("/search/{word}")
    public ResponseEntity<List<Post>> getAllPostsMatches(@PathVariable("word") String word
        ){
        return ResponseEntity
                .ok()
                .body(postSearchService.processSearch(word));
    }

    @GetMapping("/get-suggestions/{word}")
    public ResponseEntity<List<String>> getAllSuggestedSentences (
            @PathVariable("word") String word
    ){
        return ResponseEntity
                .ok()
                .body(postSearchService.fetchSuggestions(word));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity
               .ok()
               .body(postServiceWithRepo.getAllPosts());
    }


}
