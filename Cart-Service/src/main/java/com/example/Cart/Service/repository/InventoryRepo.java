package com.example.Cart.Service.repository;

import com.example.Cart.Service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, String> {
    Inventory findBySkuCode(String skuCode);
}
