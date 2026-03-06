package com.capgemini.category_product.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.category_product.dto.Product;
import com.capgemini.category_product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/category/{categoryId}")
    public Product create(@RequestBody Product p, @PathVariable Long categoryId) {
        return service.create(p, categoryId);
    }

    @GetMapping
    public List<Product> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product one(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/category/{id}")
    public List<Product> getByCategory(@PathVariable Long id) {
        return service.getByCategory(id);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return service.search(name);
    }
}