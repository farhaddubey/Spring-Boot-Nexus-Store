package com.knightsnexus.GalaxyStoreAPI.controller;

import com.knightsnexus.GalaxyStoreAPI.model.Product;
import com.knightsnexus.GalaxyStoreAPI.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // PAGINATION
    @GetMapping
    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size) {
        return productService.getProducts(page, size);
    }

    // SEARCH
    @GetMapping("/search")
    public Page<Product> search(@RequestParam String keyword, @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size) {
        return productService.searchProducts(keyword, page, size);
    }

    // SORT
    @GetMapping("/sort")
    public Page<Product> sort(@RequestParam String field, @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        return productService.getSortedProducts(field, page, size);
    }

    // JPQL
    @GetMapping("/expensive")
    public List<Product> expensive(@RequestParam double price) {
        return productService.expensiveProducts(price);
    }

    // NATIVE SQL
    @GetMapping("/native-search")
    public List<Product> nativeSearch(@RequestParam String keyword) {
        return productService.nativeSearch(keyword);
    }
}
