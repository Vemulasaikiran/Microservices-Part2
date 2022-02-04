package com.example.Inventory.Service.service;

import com.example.Inventory.Service.entity.Inventory;
import com.example.Inventory.Service.model.InventoryModel;
import com.example.Inventory.Service.repository.InventoryRepo;
import com.example.Inventory.Service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    public InventoryRepo inventoryRepo;

    @Autowired
    public ProductRepo productRepo;

    public String addStock(InventoryModel inventoryModel)
    {
        if(productRepo.findById(inventoryModel.getSkuCode()).isPresent()) {

            Inventory inventory = new Inventory();
            inventory.setInventoryId(inventoryModel.getInventoryId());
            inventory.setSkuCode(inventoryModel.getSkuCode());
            inventory.setQuantity(inventoryModel.getQuantity());
            inventoryRepo.save(inventory);
            return "Inventory Added";
        }
        return "Product Not Available";
    }
    public String updateStock(InventoryModel inventoryModel)
    {
        if(!inventoryRepo.findBySkuCode(inventoryModel.getSkuCode()).isEmpty())
        {
            List<Inventory> inventory =inventoryRepo.findBySkuCode(inventoryModel.getSkuCode());
            inventory.forEach(inv->
            {
                inv.setQuantity(inventoryModel.getQuantity());
                inventoryRepo.save(inv);
            });
            return "Product Updated";
        }
        return "Product Not Fund";
    }

}
