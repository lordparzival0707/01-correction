package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ProductCreateDto;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable int id) {

        if (id <= 0) {
            return ResponseEntity.badRequest().body("Invalid id");
        }

        return ResponseEntity.ok("Product " + id);
    }

    @GetMapping("/search")
    public Map<String, Object> searchProducts(
            @RequestParam int minPrice,
            @RequestParam int maxPrice) {
        Map<String, Object> map = new HashMap<>();

        map.put("minPrice", minPrice);
        map.put("maxPrice", maxPrice);

        return map;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductCreateDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice(), dto.getStock());
        Product saved = productService.save(product);
        return ResponseEntity.status(201).body("Product created: " + saved);
    }
}
