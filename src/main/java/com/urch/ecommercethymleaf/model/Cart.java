package com.urch.ecommercethymleaf.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_id;
    private String email;
    private String productName;
    private int quantity;
    private Double price;
    private String description;
    @ManyToOne()
    @JoinColumn(name = "productId")
    private Product product;



//    public Cart(User user, Product product, int quantity) {
//        this.user = user;
//        this.product = product;
//        this.quantity = quantity;
//    }

}
