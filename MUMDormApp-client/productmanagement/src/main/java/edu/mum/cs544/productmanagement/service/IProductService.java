package edu.mum.cs544.productmanagement.service;

import edu.mum.cs544.productmanagement.domain.Product;

import java.util.List;

public interface IProductService {
    Product get(Long id);

    List<Product> getAll();

    Long add(Product p);

    void update(Product p);

    void delete(Long id);

List<Product>findByUser(long id);
List<Product>searchByCategory(String category);


}
