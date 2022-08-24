package com.urch.ecommercethymleaf.controller;

import com.urch.ecommercethymleaf.dto.UserDto;
import com.urch.ecommercethymleaf.model.User;
import com.urch.ecommercethymleaf.service.UserService;
import com.urch.ecommercethymleaf.service.impl.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //GET LOGIN FORM
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "loginForm";
    }

    //PROCESS LOGIN FORM
    @PostMapping("/processLogin")
    public String processLogin(HttpSession session, @ModelAttribute UserDto userdto, Model model) {
        User userToBeLoggedIn;
        try {
            userToBeLoggedIn = userService.getUserByEmail(userdto.getEmail(), userdto.getPassword());
            session.setAttribute("user", userToBeLoggedIn);
        } catch (RuntimeException e) {
            model.addAttribute("invalid", e.getMessage());
            return "redirect:/login";
        }
        return "dashboard";
    }

    //GET REGISTER FORM
    @GetMapping ("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }

    //PROCESS REGISTER FORM
    @PostMapping("/processRegister")
    public String processRegister(@ModelAttribute User user, Model model, RedirectAttributes re){
        User newUser = userService.registerUser(user);
        model.addAttribute("success", newUser.getName() + " is registered successfully");
        re.addFlashAttribute("message", "User has been registered successfully");
        return "registerForm";
    }


    //API FOR MANAGING ALL USERS
    @GetMapping("/users")
    public String showAllUsers(Model model) {
       List<User> listUser = userService.getAllUsers();
       model.addAttribute("listUser", listUser);
       return "user";
    }

    //API FOR ADDING NEW USERS
    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "addUser";
    }

    //API FOR SAVING NEW USERS
    @PostMapping("/save")
    public String processAddUser(User user, Model model) {
       User newUser = userService.registerUser(user);
        model.addAttribute("pageTitle", "Add New User");
        model.addAttribute("message", newUser.getName() + " is saved successfully");
        return "addUser";
    }

    @GetMapping("/edit/{id}")
    public String showEdiTForm(@PathVariable("id") Long id, Model model, RedirectAttributes re) {
       try {
           User user = userService.getUserById(id);
           model.addAttribute("user", user);
           model.addAttribute("pageTitle", "Edit User (ID" + id +")");
           return "addUser";
       }catch(UserNotFoundException e) {
          re.addFlashAttribute("message", "User has been updated successfully");
            return "redirect:/user";
       }
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes re) {
        try {
            userService.deleteUserById(id);
        }catch(UserNotFoundException e) {
            re.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/user";
    }


}
