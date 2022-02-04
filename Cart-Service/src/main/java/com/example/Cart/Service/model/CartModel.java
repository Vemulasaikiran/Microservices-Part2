package com.example.Cart.Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartModel {

    private String cartId;
    private String productId;
//    private String email;
    private String skuCode;
    private int quantity;

}
