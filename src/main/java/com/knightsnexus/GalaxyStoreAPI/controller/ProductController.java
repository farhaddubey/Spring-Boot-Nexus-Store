package com.knightsnexus.GalaxyStoreAPI.controller;

import com.knightsnexus.GalaxyStoreAPI.model.Product;
import com.knightsnexus.GalaxyStoreAPI.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size) {
        return productService.getProducts(page, size);
    }
}
