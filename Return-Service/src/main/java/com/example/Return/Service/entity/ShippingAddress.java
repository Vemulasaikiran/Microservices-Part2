package com.example.Return.Service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shippingId;
    @Column
    private String customerId;
    @Column
    private String Line_1;
    @Column
    private String Line_2;
    @Column
    private int postalCode;
    @Column
    private String city;
    @Column
    private String state;
    @OneToOne(mappedBy = "shippingAddress")
    @JsonBackReference
    private OrderedItems orderedItems;
}
