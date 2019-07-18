package edu.mum.cs544.productmanagement.controller;

import edu.mum.cs544.productmanagement.domain.Cart;
import edu.mum.cs544.productmanagement.domain.PaymentDetail;
import edu.mum.cs544.productmanagement.domain.Product;
import edu.mum.cs544.productmanagement.repository.PaymentDetailDao;
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

    @Autowired
    private PaymentDetailDao paymentDetailDao;

    @GetMapping("/cart/{userId}")
    public List<Cart>getAll(@PathVariable(name = "userId") long userId){
        return cartService.getAll(userId);
    }

    @PostMapping(value = "/cart/")
    public Long add(@RequestBody Cart cart){
        return cartService.add(cart);
    }

    @PutMapping(value = "/cart/update")
    public void update(@RequestBody Cart cart){
        cartService.update(cart);
    }

    @DeleteMapping(value = "/cart/remove/{id}")
    public void delete(@PathVariable long id){
        cartService.delete(id);
    }

    @GetMapping("/cart/count/{uid}")
    public Integer getCartCount(@PathVariable  Long uid){
        return cartService.getAll(uid).size();
    }

    @GetMapping("/paymentDetail")
    public List<PaymentDetail> getAll(){
        return paymentDetailDao.findAll();
    }

    @PostMapping("/paymentDetail/add")
    public boolean addPaymentDetail(@RequestBody PaymentDetail paymentDetail){
        if (paymentDetailDao.save(paymentDetail) != null){
            return true;
        }
        return false;
    }

}
