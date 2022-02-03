package com.example.Return.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Registration {
    @Id
    private String customerId;
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
