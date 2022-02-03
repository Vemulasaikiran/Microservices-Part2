package com.example.ProductDetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductModel {
    private int id;
    private String productId;
    private String productName;
    private String Description;
    private String skuCode;
    private String specifications;
    private String priceCode;
    private String currency;
    private int price;


}
