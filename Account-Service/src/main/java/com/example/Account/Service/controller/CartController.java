package com.example.Account.Service.controller;

import com.example.Account.Service.client.RestService;
import com.example.Account.Service.model.CartModel;
import com.example.Account.Service.model.ProductDetailsModel;
import com.example.Account.Service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    public TokenService tokenService;
    @Autowired
    public RestService restService;


    @PostMapping("/cart/add-to-cart")
    public ResponseEntity<String> addCart(@RequestBody CartModel cartModel, @RequestHeader String token)
    {
        return restService.addToCart(cartModel,token);

    }
    @GetMapping("/cart/view-cart")
    public ResponseEntity<String> getProduct(@RequestHeader String token)
    {
        return restService.viewCart(token);
    }
    @PostMapping("/cart/place-order")
    public ResponseEntity<String> placeOrder(@RequestHeader String token)
    {
        return restService.placeOrder(token);
    }


}
