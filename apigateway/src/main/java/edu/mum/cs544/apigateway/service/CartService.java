package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.Cart;
import edu.mum.cs544.apigateway.domain.Product;

import java.util.List;

public interface CartService {
    public List<Cart>getAll(long userId);
    public void add(Cart cart);
   public void delete(long id);
}
