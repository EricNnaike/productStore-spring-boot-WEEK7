package com.urch.ecommercethymleaf.service;

import com.urch.ecommercethymleaf.dto.CartDAO;
import com.urch.ecommercethymleaf.model.Cart;
import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    Cart addToCart(Integer id, String email);
    List<Cart> getCartByEmail(String email);
//    Double getTotalCartPrice(List<Cart> cartList);
    void removeFromCart(Integer id);
}
