package com.example.Return.Service.repostory;

import com.example.Return.Service.entity.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedItemsRepo extends JpaRepository<OrderedItems, Integer> {
    OrderedItems findByEmail(String email);


}
