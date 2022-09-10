//package com.urch.ecommercethymleaf.model;
//
//import com.urch.ecommercethymleaf.model.Cart;
//import com.urch.ecommercethymleaf.model.Product;
//import com.urch.ecommercethymleaf.model.User;
//import com.urch.ecommercethymleaf.repository.CartRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import javax.persistence.EntityManager;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
//public class CartTests {
//
//    @Autowired
//    private CartRepository cartRepository;
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void addOneCartItem() {
//        Product product = entityManager.find(Product.class, 29);
//        User user = entityManager.find(User.class, 16);
//        Cart cart = new Cart();
//        cart.setUser(user);
//        cart.setQuantity(1);
//        cart.setProduct(product);
//
//        Cart savedCart = cartRepository.save(cart);
//        Assertions.assertTrue(savedCart.getCart_id() > 0);
//    }
//
//}
