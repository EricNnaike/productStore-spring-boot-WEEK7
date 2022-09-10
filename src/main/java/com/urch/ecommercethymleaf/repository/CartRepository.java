package com.urch.ecommercethymleaf.repository;

import com.urch.ecommercethymleaf.model.Cart;
import com.urch.ecommercethymleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<List<Cart>> findCartByEmail(String email);
//    Optional<Cart> findByEmailAndId(String id, Integer email);


}
