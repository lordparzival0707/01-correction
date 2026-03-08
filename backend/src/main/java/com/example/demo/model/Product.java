package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;

    private Integer stock;

    public Product() {
    };

    public Product(String name, Integer price, Integer stock) {
        setName(name);
        setPrice(price);
        setStock(stock);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

}
