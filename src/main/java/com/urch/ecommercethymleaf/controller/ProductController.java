package com.urch.ecommercethymleaf.controller;

import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.service.UserService;
import com.urch.ecommercethymleaf.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private UserService userService;

//    @GetMapping("/")

    @PostMapping("/addNewProduct")
    public Product addNewProduct(@RequestBody Product product) {
        return userService.addNewProduct(product);
    }


}
