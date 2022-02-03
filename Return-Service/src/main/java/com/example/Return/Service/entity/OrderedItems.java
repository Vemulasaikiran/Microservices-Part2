package com.example.Return.Service.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sNo;
    @Column
    private String email;
    @Column
    private String orderCode;

    @Column
    private String productCode;
    @Column
    private String skuCode;
    @Column
    private int quantity;
    @Column
    private int price;
    @Column
    private String orderStatus;

    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "address")
    @JsonManagedReference
    private ShippingAddress shippingAddress;
}
