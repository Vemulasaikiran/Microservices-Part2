package com.example.Account.Service.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartModel {
    private String cartId;
    private String productId;
    private String email;
    private String skuCode;
    private int quantity;
}
