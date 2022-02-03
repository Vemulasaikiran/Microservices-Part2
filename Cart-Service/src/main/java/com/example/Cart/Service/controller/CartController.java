package com.example.Cart.Service.controller;

import com.example.Cart.Service.service.TokenService;
import com.example.Cart.Service.model.CartModel;
import com.example.Cart.Service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    public CartService cartService;
    @Autowired
    public TokenService tokenService;

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addCart(@RequestBody CartModel cartModel, @RequestHeader String token)
    {

        if(tokenService.validToken(token)) {
            return cartService.addCart(cartModel, token);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Token Invalid \n");
    }
    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder(@RequestHeader String token)
    {
        if(tokenService.validToken(token))
        {
            String message =cartService.placeOrder(token);
            if(message.contains("Order Placed"))
            {
                return ResponseEntity.status(HttpStatus.OK).body(message);
            }
            if(message.contains("Empty Cart"))
            {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("EMPTY CART (CODE 409)");
            }
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("UNKNOWN (CODE 409)");
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("INVALID TOKEN (CODE 401)");
    }

    @GetMapping("/order-status")
    public Object getStatus(@RequestHeader String token)
    {
        if(tokenService.validToken(token))
        {
            return cartService.getStatus(token);
        }
        return "Enter Valid Token";
    }


    @GetMapping("/view-cart")
    public Object viewCart(@RequestHeader String token)
    {

        if(tokenService.validToken(token))
        {
            return cartService.viewCart(token);
        }
        return "INVALID TOKEN (CODE 401)";
    }


}
