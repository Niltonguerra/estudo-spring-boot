package com.example.estudos_spring_boot.controller;

import com.example.estudos_spring_boot.dto.ProductRequestDTO;
import com.example.estudos_spring_boot.dto.ProductResponseDTO;
import com.example.estudos_spring_boot.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO dto) {
        var product = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}