package com.example.Fulfilment.Service.service;

import com.example.Fulfilment.Service.entity.OrderedItems;
import com.example.Fulfilment.Service.repository.OrderedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FulfilmentService {
    @Autowired
    public OrderedRepo orderedRepo;


    public String updateStatus(String orderId, String status)
    {
        OrderedItems item = orderedRepo.findByOrderCode(orderId);
        if(!item.equals(null))
        {
            item.setOrderStatus(status);
            orderedRepo.save(item);
            return "STATUS UPDATED : "+item.getOrderStatus();
        }
        else return "INVALID ID";
    }


}
