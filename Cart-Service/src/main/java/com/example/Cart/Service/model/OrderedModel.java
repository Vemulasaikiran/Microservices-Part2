package com.example.Cart.Service.model;

//import com.example.Cart.Service.entity.BillingAddress;
import com.example.Cart.Service.entity.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedModel {
    private int sNo;
    private String email;
    private String orderCode;
    private String productCode;
    private String skuCode;
    private int quantity;
    private int price;
    private String orderStatus;
    private ShippingAddress shippingAddress;




//    private BillingAddress billingAddress;
//    private List<ShippingAddressModel> shippingAddress;
}
