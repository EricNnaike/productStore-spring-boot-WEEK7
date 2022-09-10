package com.urch.ecommercethymleaf.repository;

import com.urch.ecommercethymleaf.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
//    public Integer countByid(Integer id);
}
