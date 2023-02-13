package com.example.demo.controller;


import com.example.demo.model.Comment;
import com.example.demo.model.Product;
import com.example.demo.payload.ProductDto;
import com.example.demo.service.ProductSearchService;
import com.example.demo.service.ProductSearchServiceWithRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductSearchService productSearchService;
    private final ProductSearchServiceWithRepo productSearchServiceWithRepo;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ProductDto productDto){

        return ResponseEntity
                .ok()
                .body(productSearchService.createProductIndex(productDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(){
        return ResponseEntity.ok().body(productSearchServiceWithRepo.findAll());
    }

    @GetMapping("/search/{word}")
    public ResponseEntity<?> search(@PathVariable("word") String word){
        return ResponseEntity.ok().body(productSearchService.processSearch(word));
    }

    @GetMapping("/get-suggestions/{word}")
    public ResponseEntity<List<String>> getSuggestions(@PathVariable("word") String word){
        return ResponseEntity
                .ok()
                .body(productSearchService.fetchSuggestions(word));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Product>getProduct(@PathVariable("id")String id){
        return ResponseEntity
                .ok()
                .body(productSearchServiceWithRepo.findProductById(id));
    }

    @PostMapping("/addComment/{productId}")
    public ResponseEntity<?> addComment(@RequestBody Comment comment,
                                        @PathVariable("productId") String productId
    ){
        return ResponseEntity
                .ok()
                .body(productSearchServiceWithRepo.addComment(comment,productId));
    }


}
