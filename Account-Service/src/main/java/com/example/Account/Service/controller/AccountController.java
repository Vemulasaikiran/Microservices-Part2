package com.example.Account.Service.controller;

import com.example.Account.Service.client.RestTemplate;
import com.example.Account.Service.model.*;
import com.example.Account.Service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    public AccountService accountService;
    @Autowired
    public RestTemplate restService;

    @PostMapping("/add")
    public String addVal(@Valid @RequestBody RegistrationModel registrationModel)
    {
        return accountService.add(registrationModel);

    }
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginModel loginModel)
    {
        return accountService.login(loginModel);
    }


    @GetMapping("/get")
    public List<RegistrationModel> getVal()
    {
        return accountService.get();
    }

    @PostMapping("/registration/add-customer")
    public String addCustomer(@RequestBody RegistrationModel registrationModel)
    {
        return restService.addCustomer(registrationModel);
    }
    @PostMapping("/registration/login")
    public String loginRest(@RequestBody LoginModel loginModel)
    {
        return restService.login(loginModel);
    }

}
