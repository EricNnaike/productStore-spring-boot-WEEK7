package com.urch.ecommercethymleaf.service.impl;

import com.urch.ecommercethymleaf.model.Cart;
import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.repository.CartRepository;
import com.urch.ecommercethymleaf.repository.ProductRepository;
import com.urch.ecommercethymleaf.service.CartService;
import com.urch.ecommercethymleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;

    @Override
    public Cart addToCart(Integer id, String email) {
        Product product = productService.getProductById(id);

        Cart cart = new Cart();
        cart.setEmail(email);
        cart.setProductName(product.getProductName());
        cart.setQuantity(1);
        cart.setPrice(product.getPrice() * cart.getQuantity());
        cart.setDescription(product.getDescription());
        cart.setProduct(product);

        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartByEmail(String email) {
        Optional<List<Cart>> list = cartRepository.findCartByEmail(email);
        if (list.isPresent()) {
            return list.get();
        }
        throw new RuntimeException("Product does not exist");
    }

    @Override
    public void removeFromCart(Integer id) {
        cartRepository.deleteById(id);
    }

}
