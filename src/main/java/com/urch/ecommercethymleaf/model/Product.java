package com.urch.ecommercethymleaf.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private String description;
    private Double discount;
    private Double price;


}
