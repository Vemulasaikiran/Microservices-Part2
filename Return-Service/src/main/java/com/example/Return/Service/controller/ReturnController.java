package com.example.Return.Service.controller;

import com.example.Return.Service.service.ReturnService;
import com.example.Return.Service.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnController {
    @Autowired
    public ReturnService returnService;
    @Autowired
    public TokenService tokenService;

    @PostMapping("/return-service")
    public ResponseEntity<String> returnItem(@RequestParam String itemId, @RequestHeader String token)
    {

        if(tokenService.validToken(token))
        {
            String response = returnService.returnItem(itemId,token);
            if(response.contains("RETURN ACCEPTED"))
                return ResponseEntity.status(HttpStatus.OK).body(response);
            if(response.equals("INVALID ITEM ID"))
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            if(response.equals("EMAIL NOT FOUND"))
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            if(response.equals("ALREADY RETURNED"))
                return ResponseEntity.status(HttpStatus.OK).body(response);
            else
                return ResponseEntity.status(HttpStatus.CONFLICT).body("UNKNOWN");


        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("INVALID TOKEN (CODE 401)");


    }

}
