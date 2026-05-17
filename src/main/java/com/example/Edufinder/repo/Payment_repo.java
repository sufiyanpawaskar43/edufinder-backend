package com.example.Edufinder.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Edufinder.entity.Payment_entity;

public interface Payment_repo extends JpaRepository<Payment_entity, Integer> {

    Optional<Payment_entity> findByRazorpayOrderId(String razorpayOrderId);
}
