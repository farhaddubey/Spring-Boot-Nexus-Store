package com.knightsnexus.GalaxyStoreAPI.service;

import com.knightsnexus.GalaxyStoreAPI.model.Product;
import com.knightsnexus.GalaxyStoreAPI.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // PAGINATION
    public Page<Product> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }

    // SEARCH
    public Page<Product> searchProducts(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByNameContainingIgnoreCase(keyword, pageable);
    }

    // SORTING
    public Page<Product> getSortedProducts(String field, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(field));
        return productRepository.findAll(pageable);
    }

    // JPQL
    public List<Product> expensiveProducts(double price) {
        return productRepository.findExpensiveProducts(price);
    }

    // NATIVE SQL
    public List<Product> nativeSearch(String keyword) {
        return productRepository.searchNative(keyword); 
    }
}
