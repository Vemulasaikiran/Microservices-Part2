package com.example.ProductDetails.repository;

import com.example.ProductDetails.entity.ProductDetails;
import org.hibernate.usertype.LoggableUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetails,Integer> {
    List<ProductDetails> findByProductId(String productId);
//    boolean existsbyProductId(int productId);
}
