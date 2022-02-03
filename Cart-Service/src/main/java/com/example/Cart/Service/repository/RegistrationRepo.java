package com.example.Cart.Service.repository;

import com.example.Cart.Service.entity.Inventory;
import com.example.Cart.Service.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, String> {
    Registration findByEmail(String email);

}
