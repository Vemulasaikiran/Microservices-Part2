package com.example.Inventory.Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryModel {
    private String inventoryId;
    private String skuCode;
    private int quantity;

}
