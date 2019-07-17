package edu.mum.cs544.productmanagement.controller;

import edu.mum.cs544.productmanagement.domain.ShoppingCart;
//import edu.mum.cs544.productmanagement.service.ShoppingCartImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//
//@RestController
//public class ShoppingCartController {
//    @Autowired
//    private ShoppingCartImpl shoppingCart;
//    @GetMapping("/cart")
//    public List<ShoppingCart>getAll(){
//        return shoppingCart.getAll();
//    }
//    @PostMapping("/cart/add")
//    public Long add(@RequestBody ShoppingCart cart){
//        shoppingCart.add(cart);
//        return cart.getId();
//    }
//
//}
