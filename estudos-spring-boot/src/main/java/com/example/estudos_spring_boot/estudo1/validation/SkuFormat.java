package com.example.estudos_spring_boot.estudo1.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SkuFormatValidator.class)
public @interface SkuFormat {

    String message() default "SKU inválido. Formato esperado: ABC-1234";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}