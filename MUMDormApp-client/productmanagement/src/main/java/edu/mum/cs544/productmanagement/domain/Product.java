package edu.mum.cs544.productmanagement.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private String productName;
    @NotEmpty
    private String productCategory;
    private boolean status;
    private double price;
    private int quantity;
    private String productDetail;
    private String image;
    private long userId;
}
