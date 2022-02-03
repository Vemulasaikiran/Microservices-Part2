package com.example.Account.Service.controller;

import com.example.Account.Service.client.RestTemplate;
import com.example.Account.Service.model.InventoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    public RestTemplate restService;

    @PostMapping("/inventory/add-inventory")
    public String postInventory(@RequestBody InventoryModel inventoryModel)
    {
        return restService.addInventory(inventoryModel);
    }
    @PutMapping("/inventory/update-inventory")
    public String updateInventory(@RequestBody InventoryModel inventoryModel)
    {
        return restService.updateInventory(inventoryModel);
    }
}
