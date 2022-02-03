package com.example.Cart.Service.repository;

//import com.example.Cart.Service.entity.BillingAddress;
import com.example.Cart.Service.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingRepo extends JpaRepository<ShippingAddress, Integer> {
    Optional<ShippingAddress> findByCustomerId(String customerId);

}
