package com.afif.paymentapi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.afif.paymentapi.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	Optional<Payment> findByIdempotencyKey(String idempotencyKey);
	
}