package com.example.Cart.Service.repository;

import com.example.Cart.Service.entity.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedRepo extends JpaRepository<OrderedItems,Integer> {
    List<OrderedItems> findByEmail(String email);
}
