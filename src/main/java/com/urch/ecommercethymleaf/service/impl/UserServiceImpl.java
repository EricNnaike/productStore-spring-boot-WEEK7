package com.urch.ecommercethymleaf.service.impl;

import com.urch.ecommercethymleaf.model.Product;
import com.urch.ecommercethymleaf.model.User;
import com.urch.ecommercethymleaf.repository.ProductRepository;
import com.urch.ecommercethymleaf.repository.UserRepository;
import com.urch.ecommercethymleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserRepository userRepo;

   @Autowired
   private ProductRepository productRepo;

    @Override
    public User getUserByEmail(String email, String password) { //METHOD FOR LOGING USER

        Optional<User> optionalUser = userRepo.findUserByEmailAndPassword(email, password);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        else throw new RuntimeException("Invalid email or password");
    }

    @Override
    public User registerUser(User user) { //METHOD FOR REGISTERING NEW USERS
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() { //METHOD FOR GETTING ALL USERS
         return (List<User>) userRepo.findAll();

    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> result = userRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        else throw new UserNotFoundException("Could not find any user with ID: "+ id);
    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {
        Long count = userRepo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any user with ID: "+ id);
        }
        userRepo.deleteById(id);
    }





}
