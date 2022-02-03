package com.example.Cart.Service.repository;

import com.example.Cart.Service.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepo extends JpaRepository<ProductPrice, String> {
    ProductPrice findBySkuCode(String skuCode);
}
