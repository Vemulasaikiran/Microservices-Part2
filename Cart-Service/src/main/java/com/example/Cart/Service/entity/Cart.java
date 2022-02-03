package com.example.Cart.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CartTable")
public class Cart {

    @Id
    private String cartId;
    @Column
    private String email;
    @Column
    private String productId;
    @Column
    private String skuCode;
    @Column
    private int quantity;


}
