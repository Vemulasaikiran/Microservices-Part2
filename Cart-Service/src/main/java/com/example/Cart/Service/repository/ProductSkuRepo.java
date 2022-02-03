package com.example.Cart.Service.repository;

import com.example.Cart.Service.entity.ProductSku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSkuRepo extends JpaRepository<ProductSku,String> {
    ProductSku findBySkuCode(String skuCode);
}
