package edu.mum.cs544.productmanagement.repository;

import edu.mum.cs544.productmanagement.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductDao extends JpaRepository<Product, Long> {
    @Query("Select p from Product p where p.userId = :uid")
   List<Product> findByUser(@Param("uid") long uid);

    @Query("select p from Product p where p.productCategory=:category")
    List<Product>searchByCategory(@Param("category")String calegory);
}
