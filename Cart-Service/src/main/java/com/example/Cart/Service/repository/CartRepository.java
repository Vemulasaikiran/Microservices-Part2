package com.example.Cart.Service.repository;

import com.example.Cart.Service.entity.Cart;
import com.example.Cart.Service.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByEmail(String email);
    Cart findByemail(String email);
    Cart findBySkuCode(String skuCode);
}
