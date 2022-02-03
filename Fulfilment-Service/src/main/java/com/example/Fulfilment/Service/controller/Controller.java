package com.example.Fulfilment.Service.controller;

import com.example.Fulfilment.Service.service.FulfilmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    public FulfilmentService fulfilmentService;
    @PostMapping("/order-fulfilment")
    public ResponseEntity<String> updateItemStatus(@RequestHeader String itemId, @RequestHeader String status)
    {
        String message = fulfilmentService.updateStatus(itemId, status);
        if(message.contains("STATUS UPDATED"))
            return ResponseEntity.status(HttpStatus.OK).body(message);
        if(message.equals("INVALID ID"))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        return ResponseEntity.status(HttpStatus.CONFLICT).body("UNKNOWN");
    }

}
