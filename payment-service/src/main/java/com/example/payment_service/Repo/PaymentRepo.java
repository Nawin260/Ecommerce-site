package com.example.payment_service.Repo;

import com.example.payment_service.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,Long> {
    List<Payment> findByUserID(long userID);
    List<Payment> findByOrderID(long orderID);

}
