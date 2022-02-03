package com.example.Cart.Service.service;

import com.example.Cart.Service.entity.*;
import com.example.Cart.Service.model.CartModel;
import com.example.Cart.Service.model.Display;

import com.example.Cart.Service.model.OrderedModel;
import com.example.Cart.Service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class CartService {
    @Autowired
    public CartRepository cartRepository;


    @Autowired
    public RegistrationRepo registrationRepo;

    @Autowired
    public InventoryRepo inventoryRepo;

    @Autowired
    public ProductPriceRepo productPriceRepo;

//    @Autowired
//    public BillingRepo billingRepo;
    @Autowired
    public ShippingRepo shippingRepo;
    @Autowired
    public ProductSkuRepo productSkuRepo;
    @Autowired
    public OrderedRepo orderedRepo;



    public ResponseEntity<String> addCart(CartModel cartModel, String token)
    {
        TokenService tokenService = new TokenService();
        String email  = tokenService.getTokenDetails(token);
        Registration reg = registrationRepo.findByEmail(email);
        Inventory inventory = inventoryRepo.findBySkuCode(cartModel.getSkuCode());
        Integer quantityAvl = inventory.getQuantity();
        Integer quantityReq = cartModel.getQuantity();
        if(!reg.equals(null)) {
            if (quantityAvl - quantityReq >= 0) {
                Cart cart = new Cart();
                cart.setCartId(cartModel.getCartId());
                cart.setEmail(email);
                cart.setProductId(cartModel.getProductId());
                cart.setSkuCode(cartModel.getSkuCode());
                cart.setQuantity(cartModel.getQuantity());
                cartRepository.save(cart);
                return ResponseEntity.status(HttpStatus.OK).body("Added Product: "+cartModel.getProductId()+
                        "\t Quantity: "+cartModel.getQuantity()+"\n Successfully (CODE 200)");
            }
            else
            {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(email);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("INVALID TOKEN (CODE 401)");

    }

    public List<Display> viewCart(String token)
    {
        TokenService tokenService = new TokenService();
        String email  = tokenService.getTokenDetails(token);

        List<Cart> cart = cartRepository.findByEmail(email);
        List<Display> display = new ArrayList<>();
        cart.forEach(y->
        {
            int productPrice = productPriceRepo.findBySkuCode(y.getSkuCode()).getPrice();
//            Integer price = productPrice;
            Integer subTotal = (y.getQuantity()*productPrice);
            Display disp = new Display();
            disp.setSkuCode(y.getSkuCode());
            disp.setQuantity(y.getQuantity());
            disp.setPrice(productPrice);
            disp.setSubtotal(subTotal);
            display.add(disp);
        });
        return display;
    }


    public String placeOrder(String token)
    {
        TokenService tokenService = new TokenService();
        String email  = tokenService.getTokenDetails(token);
        Registration reg = registrationRepo.findByEmail(email);
        String customerId = reg.getCustomerId();
//        List<BillingAddress> billing = billingRepo.findByCustomerId(customerId);
        Optional<ShippingAddress> addresses = shippingRepo.findByCustomerId(customerId);
        System.out.println(addresses);
//        List<ShippingAddress> shipping = addresses.stream().collect(Collectors.toList());
//        System.out.println(shipping);


//        List ship = shipping.stream().map(this::addressConvertion).collect(Collectors.toList());




        if (!reg.equals(null)) {
            Cart cart = cartRepository.findByemail(email);
            if(cart!=null) {
                String skuCode = cart.getSkuCode();
                Inventory inventory = inventoryRepo.findBySkuCode(skuCode);
                System.out.println(inventory);
                    if (skuCode.equals(inventory.getSkuCode())) {
                        Integer quantityAvailable = inventory.getQuantity();
                        Integer quantityRequired = cart.getQuantity();
                        if (quantityAvailable - quantityRequired >= 0) {
                            inventoryRepo.findBySkuCode(cart.getSkuCode()).setQuantity(quantityAvailable - quantityRequired);

                        }
                    }

                ProductSku productId = productSkuRepo.findBySkuCode(inventory.getSkuCode());
                int price = productPriceRepo.findBySkuCode(skuCode).getPrice();
                int quantity = cartRepository.findBySkuCode(skuCode).getQuantity();
                int totalPrice = quantity * price;
                String uniqueId = UUID.randomUUID().toString();
                OrderedItems order = new OrderedItems();
                order.setOrderCode(uniqueId);
                order.setEmail(email);
                order.setQuantity(quantity);
                order.setProductCode(productId.getProductId());
                order.setSkuCode(inventory.getSkuCode());
                order.setPrice(totalPrice);
                order.setOrderStatus("Received");
                ShippingAddress shp = addressConvertion(addresses.get());
                order.setShippingAddress(shp);
                orderedRepo.save(order);
                return "Order Placed";
            }
            return "Empty Cart";
        }
        return "Order Placed";









    }

    public ShippingAddress addressConvertion(ShippingAddress shipping )
    {
        ShippingAddress ship = new ShippingAddress();
        ship.setShippingId(shipping.getShippingId());
        ship.setCustomerId(shipping.getCustomerId());
        ship.setLine_1(shipping.getLine_1());
        ship.setLine_2(shipping.getLine_2());
        ship.setPostalCode(shipping.getPostalCode());
        ship.setCity(shipping.getCity());
        ship.setState(shipping.getState());
        return ship;



    }
    public List<OrderedModel> getStatus(String token)
    {
        TokenService tokenService = new TokenService();
        String email  = tokenService.getTokenDetails(token);
        List<OrderedItems>ord = (List<OrderedItems>) orderedRepo.findByEmail(email);
        return ord.stream().map(this::orderConversion).collect(Collectors.toList());
    }

    public OrderedModel orderConversion(OrderedItems order)
    {
        return new OrderedModel(order.getSNo(),order.getEmail(),order.getOrderCode(),order.getProductCode(),order.getSkuCode()
        ,order.getQuantity(),order.getPrice(),order.getOrderStatus(),order.getShippingAddress());
    }



}
