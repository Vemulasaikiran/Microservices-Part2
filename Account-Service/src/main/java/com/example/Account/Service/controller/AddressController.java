package com.example.Account.Service.controller;

import com.example.Account.Service.model.BillingAddressModel;
import com.example.Account.Service.model.ShippingAddressModel;
import com.example.Account.Service.service.AccountService;
import com.example.Account.Service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private AccountService accountService;


    @PostMapping("/add-billing-address")
    public ResponseEntity<String> addBillingAdd(@RequestBody BillingAddressModel billingAddressModel,  @RequestHeader String token)
    {

        return addressService.addBilling(billingAddressModel,token);

    }
    @PostMapping("/add-shipping-address")
    public ResponseEntity<String> addShipping(@RequestBody ShippingAddressModel shippingAddressModel, @RequestHeader String token)
    {
        return addressService.addShipping(shippingAddressModel,token);
    }
    @GetMapping("/get-ship")
    private List<ShippingAddressModel> getShip()
    {
        return addressService.getShipping();
    }

//    @GetMapping("/getall/{customerId}")
//    public AllDetails getReg(@PathVariable int customerId)
//    {
//        return addressService.getall(customerId);
//    }
//





}
