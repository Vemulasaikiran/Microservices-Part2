package com.example.Account.Service.controller;

import com.example.Account.Service.client.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReturnController {
    @Autowired
    public RestService restService;
    @PostMapping("/return/return-order")
    public ResponseEntity<String> returnOrder(@RequestParam String itemId, @RequestHeader String token)
    {
        return restService.returnOrder(itemId,token);

    }

}
