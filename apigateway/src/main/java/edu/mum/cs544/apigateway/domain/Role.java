package edu.mum.cs544.apigateway.domain;

import lombok.Data;

import javax.persistence.*;


public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private String role;

    public Role() {
        this.role="User";
    }

    @Override
    public String toString() {
        return role;
    }
}
