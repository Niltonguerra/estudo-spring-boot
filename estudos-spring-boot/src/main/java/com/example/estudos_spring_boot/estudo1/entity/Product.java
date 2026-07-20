package com.example.estudos_spring_boot.estudo1.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private boolean active;

    protected Product() {} // exigido pelo JPA

    public Product(String name, String category, BigDecimal price, String sku) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.sku = sku;
        this.active = true; // regra de domínio: todo produto nasce ativo
    }

    // Getters (sem setters — entity fica imutável de fora, mudanças passam por métodos de domínio)
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public BigDecimal getPrice() { return price; }
    public String getSku() { return sku; }
    public boolean isActive() { return active; }

    // Métodos de domínio — únicas portas de mudança de estado
    public void desativar() {
        this.active = false;
    }

    public void ativar() {
        this.active = true;
    }
}