package com.example.Account.Service.client;

import com.example.Account.Service.model.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    public String addCustomer(RegistrationModel registrationModel)
    {
        org.springframework.web.client.RestTemplate rest = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8001/add";
        HttpEntity<RegistrationModel> request = new HttpEntity<>(registrationModel);
        ResponseEntity<String> response = rest.exchange(fooResourceUrl,HttpMethod.POST,request,String.class);
        System.out.println(response.getStatusCode());
        return response.getBody();

    }
    public String login(LoginModel loginModel)
    {
        org.springframework.web.client.RestTemplate rest = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8001/login";
        HttpEntity<LoginModel> request =  new HttpEntity<>(loginModel);
        ResponseEntity<String> response = rest.exchange(fooResourceUrl,HttpMethod.POST,request,String.class);
        System.out.println(response.getStatusCode());
        return response.getBody();
    }


    public ResponseEntity<String> addShipping(ShippingAddressModel shippingAddressModel, String token)
    {
        org.springframework.web.client.RestTemplate rest = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8001/add-shipping-address";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("token",token);
        HttpEntity<ShippingAddressModel> billing = new HttpEntity<>(shippingAddressModel,header);
        ResponseEntity<String> response = rest
                .exchange(fooResourceUrl , HttpMethod.POST, billing, String.class);
        return response;

    }
    public ResponseEntity<String> addToCart(CartModel cartModel, String token)
    {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8004/add-to-cart";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("token",token);
        HttpEntity<CartModel> cart = new HttpEntity<>(cartModel,header);
        ResponseEntity<String> response = restTemplate.exchange(fooResourceUrl,HttpMethod.POST,cart,String.class);
        return response;
    }
    public ResponseEntity<String> viewCart(String token)
    {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8004/view-cart";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("token",token );
        HttpEntity<?> request = new HttpEntity<>(header);
        ResponseEntity<String> response =restTemplate
                .exchange(fooResourceUrl, HttpMethod.GET, request, String.class);
        return response;

    }
    public ResponseEntity<String> placeOrder(String token)
    {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8004/place-order";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("token",token );
        HttpEntity<?> order = new HttpEntity<>(header);
        ResponseEntity<String> response = restTemplate.exchange(fooResourceUrl,HttpMethod.POST,order,String.class);
        return response;



    }




    public String addProducts(ProductDetailsModel productDetailsModel)
    {
        org.springframework.web.client.RestTemplate rest = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8002/add-products";
        HttpEntity<ProductDetailsModel> request = new HttpEntity<>(productDetailsModel);
        ResponseEntity<String> response = rest
                .exchange(fooResourceUrl, HttpMethod.POST, request, String.class);
        System.out.println(response.getStatusCode());
        return response.getBody();

    }

    public String addSku(ProductSkuModel productSkuModel)
    {
        org.springframework.web.client.RestTemplate rest = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8002/add-product-sku";
        HttpEntity<ProductSkuModel> request = new HttpEntity<>(productSkuModel);
//        HttpEntity<Integer> prod = new HttpEntity<>(productId);
        ResponseEntity<String> response = rest
                .exchange(fooResourceUrl,HttpMethod.POST,request,String.class);
        System.out.println(response.getStatusCode());
        return response.getBody();
    }
    public String addPrice(ProductPriceModel product)
    {
        org.springframework.web.client.RestTemplate rest = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8002/add-product-price";
        HttpEntity<ProductPriceModel> price = new HttpEntity<>(product);
        ResponseEntity<String> response = rest.exchange(fooResourceUrl,HttpMethod.POST,price,String.class);
        System.out.println(response.getStatusCode());
        return response.getBody();
    }
    public ProductDetailsModel[] getAllProd()
    {
        org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8002/get-products";
        ResponseEntity<ProductDetailsModel[]> response
                = restTemplate.getForEntity(fooResourceUrl, ProductDetailsModel[].class);
        System.out.println(response.getStatusCode());
        return response.getBody();
    }
    public String addInventory(InventoryModel inventoryModel)
    {
        org.springframework.web.client.RestTemplate rest = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8003/add-inventory";
        HttpEntity<InventoryModel> inventory = new HttpEntity<>(inventoryModel);

        ResponseEntity<String> response = rest.exchange(fooResourceUrl,HttpMethod.POST,inventory,String.class);
        return response.getBody();
    }
    public String updateInventory(InventoryModel inventoryModel)
    {
        org.springframework.web.client.RestTemplate rest = new org.springframework.web.client.RestTemplate();
        String fooResourceUrl = "http://localhost:8003/update-inventory";
        HttpEntity<InventoryModel> inventory = new HttpEntity<>(inventoryModel);

        ResponseEntity<String> response = rest.exchange(fooResourceUrl,HttpMethod.PUT,inventory,String.class);
        return response.getBody();
    }





}
