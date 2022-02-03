package com.example.Cart.Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Display {
    private String skuCode;
    private int price;
    private int quantity;
    private int subtotal;
}
