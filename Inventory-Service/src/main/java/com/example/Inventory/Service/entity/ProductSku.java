package com.example.Inventory.Service.entity;

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
@AllArgsConstructor
@NoArgsConstructor
public class ProductSku {
    @Id
    private String skuCode;
    @Column
    private String productId;
    @Column
    private String specifications;

}
