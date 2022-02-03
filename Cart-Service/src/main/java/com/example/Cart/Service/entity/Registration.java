package com.example.Cart.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    @Id
    private String CustomerId;
    @Column
    @NotNull(message = "Name Should not be empty")
    private String name;
    @Column
    @Email(message = "Please enter Valid email")
    private String email;
    @Column
    @NotNull(message = "Please Enter phone number")
    private long mobile_number;
    @Column
    @NotNull(message = "Please Enter Strong Password")
    private String password;

}
