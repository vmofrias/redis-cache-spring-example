package com.ldsk.caching.redis.service;

import com.ldsk.caching.redis.model.Product;
import com.ldsk.caching.redis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final Random random = new Random();

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Cacheable("products")
    public List<Product> getAllProductsWithCaching() {

        return productRepository.findAll();
    }

    @CacheEvict(value = "products", allEntries = true)
    public void createTenThousandProducts() {

        List<Product> products = new ArrayList<>();

        for(int i = 0; i < 10000; i++) {

            Product tempProduct = Product.builder()
                    .id(UUID.randomUUID())
                    .price(new BigDecimal(i))
                    .quantity(random.nextInt(100))
                    .build();

            tempProduct.setName("Product " + tempProduct.getId());

            products.add(tempProduct);
        }

        productRepository.saveAll(products);
    }

}
