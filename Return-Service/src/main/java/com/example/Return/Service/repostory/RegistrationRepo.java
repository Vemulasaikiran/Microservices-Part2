package com.example.Return.Service.repostory;

import com.example.Return.Service.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration,String> {
    Registration findByEmail(String email);

}
