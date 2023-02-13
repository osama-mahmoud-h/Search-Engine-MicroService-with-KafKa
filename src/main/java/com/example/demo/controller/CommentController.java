package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.service.PostSearchService;
import com.example.demo.service.PostServiceWithRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/comment")
@RequiredArgsConstructor
public class CommentController {

   // private final PostSearchService postSearchService;
    private final PostServiceWithRepo postServiceWithRepo;

    @PostMapping("/add/{postid}")
    public ResponseEntity<?> addCommentToPost(@PathVariable("postid") String postId,
                                              @RequestBody Comment comment
    ){
        return ResponseEntity
                .ok()
                .body(postServiceWithRepo.addCommentToPost(postId,comment));
    }

    @GetMapping("/get-all/{postid}")
    public ResponseEntity<?> getAllCommentsOnPost(@PathVariable("postid") String postId){
        return ResponseEntity
                .ok()
                .body(postServiceWithRepo.getAllCommentsOnPost(postId));
    }


}
