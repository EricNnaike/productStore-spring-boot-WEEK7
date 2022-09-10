package com.urch.ecommercethymleaf.service;

import com.urch.ecommercethymleaf.model.Product;

import java.util.List;

public interface ProductService {
    Product addNewProduct(Product product);
    List<Product> displayProduct();
    Product getProductById(Integer id);
    void deleteProductById(Integer id);
}
