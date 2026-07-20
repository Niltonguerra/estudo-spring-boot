package com.example.estudos_spring_boot.service;

import com.example.estudos_spring_boot.dto.ProductRequestDTO;
import com.example.estudos_spring_boot.dto.ProductResponseDTO;
import com.example.estudos_spring_boot.entity.Product;
import com.example.estudos_spring_boot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

        var product = new Product(dto.name(), dto.Category(),dto.price(), dto.sku());
        var saved = productRepository.save(product);

        return new ProductResponseDTO(saved.getId(), saved.getName(), saved.getPrice(), saved.getSku(), true);
    }

    public List<ProductResponseDTO> buscarPorCategoria(String category) {
        // o steam() serve para ser meio que um forEach/for do JS
        return productRepository.findByCategory(category)
                .stream()                  // 1. List<Product> vira Stream<Product>
                .map(this::toResponseDTO)  // 2. aplica a conversão em cada Product, gera Stream<ProductResponseDTO>
                .toList();                 // 3. Stream<ProductResponseDTO> vira List<ProductResponseDTO>
    }

    public List<ProductResponseDTO> buscarNaFaixaDePreco(BigDecimal min, BigDecimal max) {
        return productRepository.findActiveProductsInPriceRange(min, max)
                .stream()                  // 1. List<Product> vira Stream<Product>
                .map(this::toResponseDTO)  // 2. aplica a conversão em cada Product, gera Stream<ProductResponseDTO>
                .toList();                 // 3. Stream<ProductResponseDTO> vira List<ProductResponseDTO>
    }

    private ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getSku(),
                product.isActive()
        );
    }
}