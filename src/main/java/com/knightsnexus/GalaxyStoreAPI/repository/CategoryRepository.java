package com.knightsnexus.GalaxyStoreAPI.repository;

import com.knightsnexus.GalaxyStoreAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
