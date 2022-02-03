package com.example.Return.Service.repostory;

import com.example.Return.Service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, String> {
    Inventory findBySkuCode(String skuCode);

}
