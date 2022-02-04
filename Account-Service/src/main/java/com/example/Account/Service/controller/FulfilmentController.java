package com.example.Account.Service.controller;

import com.example.Account.Service.client.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FulfilmentController {
    @Autowired
    public RestService restService;
    @PostMapping("/fulfilment/order-fulfilment")
    public ResponseEntity<String>fulfilment(@RequestParam String itemId, @RequestParam String status)
    {
        return restService.fulFilments(itemId,status);
    }

}
