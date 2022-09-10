package com.urch.ecommercethymleaf.controller;

import com.urch.ecommercethymleaf.model.Cart;
import com.urch.ecommercethymleaf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    //Add to cart
    @GetMapping("/addToCart/{productId}")
    public String addToCart(@ModelAttribute String email, @PathVariable("productId") Integer id, Model model) {
        cartService.addToCart(id, email);
        model.addAttribute("message", "Product added to cart");
        return "redirect:/customerViewProduct";
    }

    //View cart
    @GetMapping("/viewCart")
    public ModelAndView viewMyCart(@ModelAttribute String email, Model model) {
        List<Cart> cartList = cartService.getCartByEmail(email);
        ModelAndView mav = new ModelAndView("viewCart");
        mav.addObject("cartList", cartList);
        mav.addObject("email", email);
        return mav;
    }

    //Remove from cart
    @GetMapping("/removeCart/{cart_id}")
    public String removeCart(@ModelAttribute("cart_id") Integer id, RedirectAttributes re) {
        cartService.removeFromCart(id);
        re.addFlashAttribute("message", "Product deleted successfully");
        return "redirect:/viewCart";
    }

}
