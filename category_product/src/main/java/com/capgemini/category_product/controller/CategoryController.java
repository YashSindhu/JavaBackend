package com.capgemini.category_product.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.category_product.dto.Category;
import com.capgemini.category_product.exception.CategoryNotFoundException;
import com.capgemini.category_product.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category create(@RequestBody Category c) {
        return service.create(c);
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    
    @GetMapping("/page/{page}/{size}")
    public Object getCategory(@PathVariable int page, @PathVariable int size) {
        return service.getPaged(page, size);
    }
    
    @GetMapping("/get-id/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {

        Category c = service.getByIdCustom(id);

        if (c != null) {
            return new ResponseEntity<>(
                    c,
                    HttpStatus.FOUND   // 302
            );
        } else {
        	throw new CategoryNotFoundException("Category not found with id: " + id);
        }
    }
}