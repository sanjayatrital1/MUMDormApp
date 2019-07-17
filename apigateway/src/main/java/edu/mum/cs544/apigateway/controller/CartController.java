package edu.mum.cs544.apigateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs544.apigateway.domain.Cart;
import edu.mum.cs544.apigateway.domain.Product;
import edu.mum.cs544.apigateway.service.CartProxy;
import edu.mum.cs544.apigateway.service.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    CartProxy cartProxy;

    @Autowired
    ProductProxy productProxy;
    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/cart")
    public String getAll( Model model, Cart cart){
        model.addAttribute("cart",cartProxy.getAll(1));
        return "home";
    }

    @GetMapping("/cart/remove/{id}")
    public String  removeCartItem(@PathVariable(name = "id") long id ){
        cartProxy.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "/cart/add/{productId}")
    public String addToCart(@PathVariable(name = "productId") long productId){
        Cart cart = new Cart();
        Product product = productProxy.get(productId);
        cart.setUserId(1);
        cart.setProductId(productId);
        cart.setProductName(product.getProductName());
        cart.setQuantity(1);
        cart.setRate(product.getPrice());
        cart.setPrice(1 * product.getPrice());
        cartProxy.add(cart);
        return "redirect:/";
    }



}
