package com.knightsnexus.GalaxyStoreAPI.repository;

import com.knightsnexus.GalaxyStoreAPI.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // SEARCH
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // JPQL
    @Query("""
           SELECT p  FROM Product p WHERE p.price > :price
           """)
    List<Product> findExpensiveProducts(@Param("price") double price);

    // NATIVE SQL
    @Query(value =  """
                    SELECT * FROM product WHERE name ILIKE %:keyword%
                    """,
            nativeQuery = true)
    // ILILKE IS POSTGRE SQL FEATURE
    // LIKE -> CASE SENSITIVE
    // ILIKE -> CASE INSENSITIVE
    List<Product> searchNative(@Param("keyword") String keyword);
}
