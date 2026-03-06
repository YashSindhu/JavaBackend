package com.capgemini.category_product.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.category_product.dto.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByCategoryName(String categoryName);
}