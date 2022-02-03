package com.example.Inventory.Service.repository;

import com.example.Inventory.Service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepo extends JpaRepository<Inventory, String> {
    List<Inventory> findBySkuCode(String skuCode);
}
