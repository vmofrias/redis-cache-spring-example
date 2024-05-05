package com.ldsk.caching.redis.controller;

import com.ldsk.caching.redis.model.Product;
import com.ldsk.caching.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/cache")
    public ResponseEntity<List<Product>> getAllProductsWithCaching() {

        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductsWithCaching());
    }

    @PostMapping
    public ResponseEntity<Void> createProducts() {

        productService.createTenThousandProducts();

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
