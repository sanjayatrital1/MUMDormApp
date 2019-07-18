package edu.mum.cs544.apigateway.domain;

import lombok.Data;


@Data
public class Cart {

    private long id;
    private long userId;
    private long productId;
    private String productName;
    private int quantity;
    private double rate;
    private String image;
    private double price;




}
