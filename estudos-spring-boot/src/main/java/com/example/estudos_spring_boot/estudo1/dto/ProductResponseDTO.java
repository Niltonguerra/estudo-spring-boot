package com.example.estudos_spring_boot.estudo1.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        BigDecimal price,
        String sku,
        boolean active
) {}