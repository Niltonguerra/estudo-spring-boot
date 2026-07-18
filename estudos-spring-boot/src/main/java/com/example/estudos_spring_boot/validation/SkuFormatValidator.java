package com.example.estudos_spring_boot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SkuFormatValidator implements ConstraintValidator<SkuFormat, String> {

    private static final String SKU_REGEX = "^[A-Z]{3}-\\d{4}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // deixa o @NotNull cuidar disso, separa responsabilidades
        }
        return value.matches(SKU_REGEX);
    }
}