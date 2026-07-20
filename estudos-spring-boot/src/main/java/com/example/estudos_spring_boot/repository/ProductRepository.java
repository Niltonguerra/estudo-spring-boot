package com.example.estudos_spring_boot.repository;

import com.example.estudos_spring_boot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySku(String sku);

    // Query Method — busca por igualdade exata
    List<Product> findByCategory(String category);

    // Query Method — condição composta (AND)
    List<Product> findByCategoryAndActiveTrue(String category);

    // Query Method — comparação numérica + ordenação
    List<Product> findByPriceLessThanOrderByPriceAsc(BigDecimal price);

    // Query Method — busca textual parcial, case-insensitive
    List<Product> findByNameContainingIgnoreCase(String name);

    // @Query com JPQL — quando o nome do método ficaria complexo
    // ou quando você precisa de controle explícito sobre a consulta
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max AND p.active = true")
    List<Product> findActiveProductsInPriceRange(
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max
    );

    // @Query com JPQL retornando um campo agregado
    @Query("SELECT AVG(p.price) FROM Product p WHERE p.category = :category")
    BigDecimal findAveragePriceByCategory(@Param("category") String category);

}