package com.example.ProductDetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceModel {

    private String priceCode;
    private String skuCode;
    private String currency;
    private int price;
}
