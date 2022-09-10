package com.urch.ecommercethymleaf.service;

import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.model.User;
import com.urch.ecommercethymleaf.service.impl.UserNotFoundException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email, String password);
    User registerUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id) throws UserNotFoundException;
    void deleteUserById(Long id) throws UserNotFoundException;
}
