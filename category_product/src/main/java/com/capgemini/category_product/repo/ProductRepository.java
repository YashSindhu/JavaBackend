package com.capgemini.category_product.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.category_product.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductNameContaining(String name);
    List<Product> findByCategoryCategoryId(Long id);
}