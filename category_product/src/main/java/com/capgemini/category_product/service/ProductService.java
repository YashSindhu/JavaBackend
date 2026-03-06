package com.capgemini.category_product.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.category_product.dto.Category;
import com.capgemini.category_product.dto.Product;
import com.capgemini.category_product.exception.CategoryNotFoundException;
import com.capgemini.category_product.exception.InvalidProductDataException;
import com.capgemini.category_product.exception.ProductNotFoundException;
import com.capgemini.category_product.repo.CategoryRepository;
import com.capgemini.category_product.repo.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public Product create(Product p, Long categoryId) {

        if (p.getPrice() <= 0)
            throw new InvalidProductDataException("Price must be positive");

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        p.setCategory(category);
        return productRepo.save(p);
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public Product get(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public List<Product> getByCategory(Long categoryId) {
        return productRepo.findByCategoryCategoryId(categoryId);
    }

    public List<Product> search(String name) {
        return productRepo.findByProductNameContaining(name);
    }
}