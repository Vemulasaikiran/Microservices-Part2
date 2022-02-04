package com.example.Account.Service.model;

import com.example.Account.Service.entity.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedModel {
    private int sNo;
    private String email;
    private String orderCode;
    private String productCode;
    private String skuCode;
    private int quantity;
    private int price;
    private String orderStatus;
    private ShippingAddress shippingAddress;
}
