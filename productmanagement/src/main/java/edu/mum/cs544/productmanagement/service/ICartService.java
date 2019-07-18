package edu.mum.cs544.productmanagement.service;

import edu.mum.cs544.productmanagement.domain.Cart;
import edu.mum.cs544.productmanagement.domain.Product;

import java.util.List;

public interface ICartService {
    public List<Cart>getAll(long userId);
    public long add(Cart cart);
    public void update(Cart c);
    public void delete(long id);
}
