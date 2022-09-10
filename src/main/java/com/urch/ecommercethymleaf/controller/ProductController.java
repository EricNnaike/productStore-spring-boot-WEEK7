package com.urch.ecommercethymleaf.controller;

import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.service.ProductService;
import com.urch.ecommercethymleaf.service.UserService;
import com.urch.ecommercethymleaf.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productform")  //GET PRODUCT FORM
    public String ProductForm(Model model) {
        model.addAttribute("product", new Product());
        System.out.println("1");
        model.addAttribute("pagetitle", "Add Product");
        return "addproduct";
    }

//    @PostMapping("/addNewProduct")
//    public String addNewProduct(@RequestBody Product product, Model model) {
//        System.out.println("2");
//           model.addAttribute("message", "Product added successfully");
//           productService.addNewProduct(product);
//           return "addproduct";
//
//    }
    @PostMapping("/addNewProduct")  //PROCESS PRODUCT FORM
    public String addNewProduct(@ModelAttribute("product") Product product, Model model){
        model.addAttribute("message", "Product added successfully");
        productService.addNewProduct(product);
        return "addproduct";
    }

    @GetMapping("/dispayAllProduct")
    public String getAllProduct(Model model) {
       List<Product> productList = productService.displayProduct();
       model.addAttribute("productList", productList);
       model.addAttribute("titlehead", "PRODUCTS DISPLAY");
       return "viewProduct";
    }

    //NAVIGATE TO UPDATEPRODUCTFORM
    @GetMapping("/updateProductForm")  //GET PRODUCT FORM
    public String updateProduct(Model model) {
        List<Product> productList = productService.displayProduct();
        model.addAttribute("productList", productList);
        model.addAttribute("pagetitle", "Update Product");
        return "updateProduct";
    }


    @GetMapping("/editproduct/{productId}")    //UPDATE PRODUCT
    public String updateProductForm(@PathVariable("productId") Integer id, Model model ) {
        try {
            Product prod = productService.getProductById(id);
            model.addAttribute("product", prod);
            model.addAttribute("pagetitle", "Update Product");
            return "addproduct";
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return "updateProduct";
        }
    }

    //DELETE PRODUCT
    @GetMapping("/deleteproduct/{productId}")
    public String deleteProduct(@PathVariable("productId") Integer id, RedirectAttributes re) {
            productService.deleteProductById(id);
            re.addFlashAttribute("Product deleted successfully");
        return "updateProduct";
    }

    //CUSTOMER SECTION
    @GetMapping("/customerViewProduct")
    public String productPage(Model model) {
        List<Product> productList = productService.displayProduct();
        model.addAttribute("productList", productList);
        model.addAttribute("titlehead", "PRODUCTS DISPLAY");
        return "customerViewProduct";
    }




}
