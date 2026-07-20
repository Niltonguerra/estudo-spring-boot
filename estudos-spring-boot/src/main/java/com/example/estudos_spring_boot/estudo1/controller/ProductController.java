package com.example.estudos_spring_boot.estudo1.controller;

import com.example.estudos_spring_boot.estudo1.dto.ProductRequestDTO;
import com.example.estudos_spring_boot.estudo1.dto.ProductResponseDTO;
import com.example.estudos_spring_boot.estudo1.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> buscarPorCategoria(@PathVariable String category) {
        var products = productService.buscarPorCategoria(category);
        return ResponseEntity.status(HttpStatus.FOUND).body(products);
    }

    @GetMapping("buscarNaFaixaDePreco")
    public ResponseEntity<List<ProductResponseDTO>> buscarNaFaixaDePreco( @RequestParam String min, @RequestParam String max ) {
        BigDecimal minimo = new BigDecimal(min);
        BigDecimal maximo = new BigDecimal(max);
        var products = productService.buscarNaFaixaDePreco(minimo, maximo);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}