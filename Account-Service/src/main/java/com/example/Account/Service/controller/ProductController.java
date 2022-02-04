package com.example.Account.Service.controller;

import com.example.Account.Service.client.RestService;
import com.example.Account.Service.model.ProductDetailsModel;
import com.example.Account.Service.model.ProductPriceModel;
import com.example.Account.Service.model.ProductSkuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    public RestService restService;

    @GetMapping("/product/get-product")
    public ProductDetailsModel[] getProduct()
    {
        return restService.getAllProd();
    }


    @PostMapping("/product/add-product")
    public  String postProduct(@RequestBody ProductDetailsModel productDetailsModel)
    {
        return restService.addProducts(productDetailsModel);
    }

    @PostMapping("/product/add-product-sku")
    public String addProductSku(@RequestBody ProductSkuModel productSkuModel)
    {
        return restService.addSku(productSkuModel);
    }
    @PostMapping("/product/add-product-price")
    public String addPrice(@RequestBody ProductPriceModel productPriceModel)
    {
        return restService.addPrice(productPriceModel);
    }
}
