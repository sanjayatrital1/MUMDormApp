package edu.mum.cs544.productmanagement.repository;

import edu.mum.cs544.productmanagement.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface CartDao extends JpaRepository<Cart, Long> {

   public List<Cart> findByUserId(long userId);
}
