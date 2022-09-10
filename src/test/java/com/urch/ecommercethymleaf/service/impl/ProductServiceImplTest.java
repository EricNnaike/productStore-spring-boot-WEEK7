package com.urch.ecommercethymleaf.service.impl;

import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.repository.ProductRepository;
import com.urch.ecommercethymleaf.service.ProductService;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)

@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    void addNewProduct() {
        Product product = new Product();
        product.setProductName("Ghana suit");
        product.setDescription("Men's sjirt");
        product.setDiscount(1000.0);
        product.setPrice(5000.00);

        Product product1 = productRepository.save(product);
        assertTrue(product1.getProductId() > 0);
    }

    @Test
    void displayProduct() {
        Product product = new Product();
        product.setProductName("Turky suit");
        product.setDescription("Women's gown");
        product.setDiscount(1500.00);
        product.setPrice(7500.00);
        List<Product> list = new ArrayList<>();
        list.add(product);

        List<Product> productList  = (List<Product>) productRepository.findAll();
        assertTrue(productList.size() > 0);
    }

    @Test
    void getProductById() {
        Product product = entityManager.find(Product.class, 39);
        Product product1 = productRepository.findById(product.getProductId()).get();
        assertEquals(39, product1.getProductId());
    }

    @Mock
    ProductRepository productRepository1;
    @InjectMocks
    ProductServiceImpl productServiceimpl;
    @Test
    void testGetProductById() {
        Product product = entityManager.find(Product.class, 42);
        when(productRepository1.findById(product.getProductId())).thenReturn(Optional.of(product));
        Product id = productServiceimpl.getProductById(product.getProductId());
        assertEquals(product, id);
    }

}