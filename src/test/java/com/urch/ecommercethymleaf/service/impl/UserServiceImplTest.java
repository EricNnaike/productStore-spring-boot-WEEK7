package com.urch.ecommercethymleaf.service.impl;

import com.urch.ecommercethymleaf.model.User;
import com.urch.ecommercethymleaf.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    UserServiceImpl userServiceImpl;
    @Mock
    EntityManager entityManager;

    @Test
    void getUserByEmail() {
        User user = entityManager.find(User.class, 20);
        when(userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));
        User actual = userServiceImpl.getUserByEmail(user.getEmail(), user.getPassword());
        assertEquals(user, actual);
    }

    @Test
    void registerUser() {
        User user = new User();
        user.setName("Chiamaka");
        user.setEmail("chiamaka@gmail.com");
        user.setPassword("chi23");
        user.setEnabled(true);
        when(userRepository.save(user)).thenReturn(user);
        User savedUser = userServiceImpl.registerUser(user);
        assertEquals(user, savedUser);
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void deleteUserById() {
    }
}