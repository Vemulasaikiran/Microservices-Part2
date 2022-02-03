package com.example.ProductDetails.controller;
//import com.example.ProductDetails.entity.Product;
import com.example.ProductDetails.model.ProductDetailsModel;
import com.example.ProductDetails.model.ProductModel;
import com.example.ProductDetails.model.ProductPriceModel;
import com.example.ProductDetails.model.ProductSkuModel;
import com.example.ProductDetails.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    public ProductService productService;


    @PostMapping("/add-products")
    private void addProduct(@RequestBody ProductDetailsModel productDetails)
    {
        productService.addProduct(productDetails);
    }

    @PostMapping("/add-product-sku")
    private String addSku(@RequestBody ProductSkuModel productSkuModel)
    {
        return productService.addSku(productSkuModel);
    }
    @PostMapping("/add-product-price")
    private String addPrice(@RequestBody ProductPriceModel productPriceModel)
    {
        return productService.addPrice(productPriceModel);
    }

    @GetMapping("/get-products")
    private List<ProductDetailsModel> productDetails()
    {
        return productService.getProd();
    }



    @GetMapping("/get-sku")
    private List<ProductSkuModel> productSku()
    {
        return productService.getSku();
    }

    @GetMapping("/get-all")
    private List getAll()
    {
        return productService.getall();
    }
//    @GetMapping("/get-all-products")
//    private List<ProductModel> prod()
//    {
//        return productService.getAllProducts();
//    }



}
