package com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.service;

import com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    public ProductService() {
        // Initialize some dummy data
        products = new ArrayList<>();
        products.add(new Product(1L, "Laptop", "High-performance laptop", 1500.0));
        products.add(new Product(2L, "Smartphone", "Latest model smartphone", 800.0));
        products.add(new Product(3L, "Headphones", "Noise-cancelling headphones", 200.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
