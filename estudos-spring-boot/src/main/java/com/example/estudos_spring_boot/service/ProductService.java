package com.example.estudos_spring_boot.service;

import com.example.estudos_spring_boot.dto.ProductRequestDTO;
import com.example.estudos_spring_boot.dto.ProductResponseDTO;
import com.example.estudos_spring_boot.entity.Product;
import com.example.estudos_spring_boot.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO create(ProductRequestDTO dto) {
        if (productRepository.existsBySku(dto.sku())) {
            throw new IllegalArgumentException("SKU já cadastrado: " + dto.sku());
        }

        var product = new Product(dto.name(), dto.price(), dto.sku());
        var saved = productRepository.save(product);

        return new ProductResponseDTO(saved.getId(), saved.getName(), saved.getPrice(), saved.getSku());
    }
}