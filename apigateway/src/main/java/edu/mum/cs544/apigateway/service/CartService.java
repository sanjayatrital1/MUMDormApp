package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.Cart;
import edu.mum.cs544.apigateway.domain.PaymentDetail;
import edu.mum.cs544.apigateway.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public List<Cart>getAll(long userId);
    public void add(Cart cart);
    public void delete(long id);
    public boolean addPayDetail(PaymentDetail pd);
    public List<PaymentDetail> getAllPayDetails();
}
