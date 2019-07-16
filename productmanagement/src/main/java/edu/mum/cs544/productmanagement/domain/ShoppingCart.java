package edu.mum.cs544.productmanagement.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
public class ShoppingCart {
//    @Id
//    @GeneratedValue
    private long id;
    private String name;
    private String description;
//    @OneToMany
    private List<Product> productList;
}
