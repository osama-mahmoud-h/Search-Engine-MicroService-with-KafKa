package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostSearchService {

    List<Post> processSearch(final String searchWord);
     List<String> fetchSuggestions(final String searchWord);

}
