package com.example.Return.Service.service;

import com.example.Return.Service.entity.Inventory;
import com.example.Return.Service.entity.OrderedItems;
import com.example.Return.Service.entity.Registration;
import com.example.Return.Service.repostory.InventoryRepo;
import com.example.Return.Service.repostory.OrderedItemsRepo;
import com.example.Return.Service.repostory.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnService {
    @Autowired
    public RegistrationRepo registrationRepo;
    @Autowired
    public InventoryRepo inventoryRepo;
    @Autowired
    public OrderedItemsRepo orderedItemsRepo;
    public String returnItem(String itemId, String token) {

        TokenService auth = new TokenService();
        String email = auth.getTokenDetails(token);
        Registration reg = registrationRepo.findByEmail(email);
        OrderedItems item = orderedItemsRepo.findByEmail(email);

        if (!reg.equals(null) && !item.getOrderStatus().equals("RETURNED")) {


            if (!reg.equals(null)) {
                Inventory inv = inventoryRepo.findBySkuCode(item.getSkuCode());
                inv.setQuantity(inv.getQuantity() + item.getQuantity());
                item.setOrderStatus("RETURNED");
                inventoryRepo.save(inv);
                return "RETURN ACCEPTED\n ITEM ID: " + item.getOrderCode() + "\tREFUND AMOUNT: " + (item.getPrice());
            } else return "INVALID ITEM ID";


        }
        else return "ALREADY RETURNED";


    }

}
