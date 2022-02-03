package com.example.Fulfilment.Service.repository;

import com.example.Fulfilment.Service.entity.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepo extends JpaRepository<OrderedItems, Integer> {
    OrderedItems findByOrderCode(String orderCode);
}
