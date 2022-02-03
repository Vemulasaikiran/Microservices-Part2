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
public class ShippingAddressModel {
    private int shippingId;
    private String customerId;
    private String Line_1;
    private String Line_2;
    private int postalCode;
    private String city;
    private String state;
}
