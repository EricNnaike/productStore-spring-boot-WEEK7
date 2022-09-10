package com.urch.ecommercethymleaf.service.impl;

import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.repository.ProductRepository;
import com.urch.ecommercethymleaf.service.ProductService;
import com.urch.ecommercethymleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product addNewProduct(Product product) { //METHOD FOR ADDING NEW PRODUCT
        Product productItems = productRepo.save(product);
        return productItems;
    }

    @Override
    public List<Product> displayProduct() {
      return (List<Product>) productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> result = productRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new RuntimeException("Product "+ id+ " not found");
    }

    @Override
    public void deleteProductById(Integer id) {
//        Integer count = productRepo.countByid(id);
//        if (count == null || count == 0) {
//            throw new RuntimeException("Could not find any product with the id "+ id);
//        }
        productRepo.deleteById(id);
    }
}
