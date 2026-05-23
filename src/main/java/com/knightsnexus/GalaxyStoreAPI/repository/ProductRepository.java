package com.knightsnexus.GalaxyStoreAPI.repository;

import com.knightsnexus.GalaxyStoreAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
