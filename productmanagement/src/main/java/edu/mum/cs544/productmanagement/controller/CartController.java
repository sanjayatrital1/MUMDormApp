package edu.mum.cs544.productmanagement.controller;

import edu.mum.cs544.productmanagement.domain.Cart;
import edu.mum.cs544.productmanagement.domain.Product;
import edu.mum.cs544.productmanagement.service.CartServiceImpl;
import edu.mum.cs544.productmanagement.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController

public class CartController {

    @Autowired
   private CartServiceImpl cartService;

    @GetMapping("/cart/{userId}")
    public List<Cart>getAll(@PathVariable(name = "userId") long userId){
        return cartService.getAll(userId);
    }

    @PostMapping(value = "/cart/")
    public Long add(@RequestBody Cart cart){

        return cartService.add(cart);
    }



    @DeleteMapping(value = "/cart/remove/{id}")
    public void delete(@PathVariable long id){
        cartService.delete(id);
    }




}
