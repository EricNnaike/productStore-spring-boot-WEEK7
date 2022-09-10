package com.urch.ecommercethymleaf.service.impl;

import com.urch.ecommercethymleaf.model.Cart;
import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.model.User;
import com.urch.ecommercethymleaf.repository.CartRepository;
import com.urch.ecommercethymleaf.repository.ProductRepository;
import com.urch.ecommercethymleaf.service.ProductService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)

class CartServiceImplTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    void addToCart() {
       Product product = entityManager.find(Product.class, 33);
       User user = entityManager.find(User.class, Long.parseLong(String.valueOf(16)));
       Cart cart = new Cart();
       cart.setProduct(product);
       cart.setEmail(String.valueOf(user));

       Cart savedCart = cartRepository.save(cart);
       assertNotNull(savedCart);
    }

    @Test
    void getCartByEmail() {
        User user = new User();
        user.setEmail("uchenna@gmail.com");
        Optional<List<Cart>> cartEmail = cartRepository.findCartByEmail(String.valueOf(user));
        assertNotNull(cartEmail);
    }

}