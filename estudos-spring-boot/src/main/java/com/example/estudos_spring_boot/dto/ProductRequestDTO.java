package com.example.estudos_spring_boot.dto;

import com.example.estudos_spring_boot.validation.SkuFormat;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100)
        String name,

        @NotNull(message = "Preço é obrigatório")
        @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
        BigDecimal price,

        @NotBlank
        @SkuFormat
        String sku
) {}