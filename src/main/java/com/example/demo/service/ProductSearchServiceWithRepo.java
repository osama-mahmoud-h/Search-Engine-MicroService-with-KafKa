package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.model.Product;
import com.example.demo.payload.ProductDto;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductSearchServiceWithRepo {

    private final ProductRepository productRepository;

    public List<Product>findAll(){
        return productRepository.findAll();
    }
    public void createProductIndexBulk(final List<Product> products) {
        productRepository.saveAll(products);
    }

    public Product createProductIndex(ProductDto productDto) {
        Product product = new Product();

        product.setId(productDto.getId());
        product.setQuantity(productDto.getQuantity());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setManufacturer(productDto.getManufacturer());

       Product saved =  productRepository.save(product);
       return saved;
    }

    public Product findProductById(final String id){
        return productRepository.findProductById(id);
    }

    public List<Product> findProductsByManufacturerAndCategory(final String manufacturer, final String category) {
        return productRepository.findByManufacturerAndCategory(manufacturer, category);
    }

    public List<Product> findByProductName(final String productName) {
        return productRepository.findByName(productName);
    }

    public List<Product> findByProductMatchingNames(final String productName) {
        return productRepository.findByNameContaining(productName);
    }

    public Product addComment(Comment comment ,String productId){
        Product product = findProductById(productId);
        product.getComments().add(comment);
        productRepository.save(product);
        return product;
    }

}