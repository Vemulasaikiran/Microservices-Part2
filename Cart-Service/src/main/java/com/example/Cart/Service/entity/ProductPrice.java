package com.example.Cart.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {
    @Id
    private String priceCode;
    @Column
    private String skuCode;
    @Column
    private String currency;
    @Column
    private int price;
}
