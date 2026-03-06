package com.capgemini.category_product.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.capgemini.category_product.dto.Category;
import com.capgemini.category_product.exception.CategoryNotFoundException;
import com.capgemini.category_product.repo.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category create(Category c) {
        return repo.save(c);
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Category get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    public Category update(Long id, Category newData) {
        Category c = get(id);
        c.setCategoryName(newData.getCategoryName());
        c.setDescription(newData.getDescription());
        return repo.save(c);
    }

    public void delete(Long id) {
        get(id);
        repo.deleteById(id);
    }
    
    public Page<Category> getPaged(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
    
    public Category getByIdCustom(Long id) {
        return repo.findById(id)
                   .orElse(null);   // return null if not found (matches your requirement)
    }
}