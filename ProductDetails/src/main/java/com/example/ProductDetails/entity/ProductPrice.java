package com.example.ProductDetails.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ProductPrice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductPrice {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sNo;
    @Column
    private String priceCode;
    @Column
    private String skuCode;
    @Column
    private String currency;
    @Column
    private int price;
}
