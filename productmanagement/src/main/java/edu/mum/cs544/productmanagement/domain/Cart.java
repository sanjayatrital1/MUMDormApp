package edu.mum.cs544.productmanagement.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private long productId;
    private String productName;
    private int quantity;
    private double rate;
    private double price;




}
