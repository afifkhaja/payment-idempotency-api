package com.afif.paymentapi.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.afif.paymentapi.dto.PaymentRequest;
import com.afif.paymentapi.dto.PaymentResponse;
import com.afif.paymentapi.entity.Payment;
import com.afif.paymentapi.repository.PaymentRepository;

@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;
	
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public PaymentResponse processPayment(PaymentRequest request) {
		
		Optional<Payment> existingPayment = paymentRepository.findByIdempotencyKey(request.getIdempotencyKey());
		
		if(existingPayment.isPresent()) {
			Payment payment = existingPayment.get();
			return new PaymentResponse(
					payment.getId(), payment.getUserId(), payment.getAmount(), payment.getIdempotencyKey(), 
					"Payment already processed. Returning existing record."
			);
		}
		
		Payment newPayment = new Payment(
				request.getUserId(),
				request.getAmount(),
				request.getIdempotencyKey()
		);
		
		Payment savedPayment = paymentRepository.save(newPayment);
		
		return new PaymentResponse(
			savedPayment.getId(),
			savedPayment.getUserId(),
			savedPayment.getAmount(),
			savedPayment.getIdempotencyKey(),
			"Payment processed successfully."
		);
		
	}
	
}