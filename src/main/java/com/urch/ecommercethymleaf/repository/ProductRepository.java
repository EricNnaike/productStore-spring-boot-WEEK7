package com.urch.ecommercethymleaf.repository;

import com.urch.ecommercethymleaf.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
