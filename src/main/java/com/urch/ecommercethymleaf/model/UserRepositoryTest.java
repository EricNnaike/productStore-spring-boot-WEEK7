//package com.urch.ecommercethymleaf.model;
//
//import com.urch.ecommercethymleaf.model.User;
//import com.urch.ecommercethymleaf.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testAddNewUser() {
//        User user = new User();
//        user.setName("Uchenna");
//        user.setEmail("nnaikeuchenna@gmail.com");
//        user.setPassword("1234");
//
//        User userTest = userRepository.save(user);
//        Assertions.assertNotNull(userTest);
////        Assertions.assertThat(userTest).isNotNull();
////        Assertions.assertThat(userTest.getId()).isGreaterThan(0);
//    }
//}
