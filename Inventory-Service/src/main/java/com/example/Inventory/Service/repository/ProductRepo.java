package com.example.Inventory.Service.repository;

import com.example.Inventory.Service.entity.ProductSku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductSku,String> {
}
