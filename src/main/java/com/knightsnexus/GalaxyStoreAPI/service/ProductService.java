package com.knightsnexus.GalaxyStoreAPI.service;

import com.knightsnexus.GalaxyStoreAPI.model.Product;
import com.knightsnexus.GalaxyStoreAPI.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }
}
