package com.example.Inventory.Service.controller;

import com.example.Inventory.Service.model.InventoryModel;
import com.example.Inventory.Service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    public InventoryService inventoryService;

    @PostMapping("/add-inventory")
    private String addStock(@RequestBody InventoryModel inventoryModel)
    {
        return inventoryService.addStock(inventoryModel);
    }
    @PutMapping("/update-inventory")
    private String updateStock(@RequestBody InventoryModel inventoryModel)
    {
        return inventoryService.updateStock(inventoryModel);
    }

}
