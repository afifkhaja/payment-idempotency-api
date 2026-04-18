package com.afif.paymentapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.afif.paymentapi.dto.PaymentRequest;
import com.afif.paymentapi.dto.PaymentResponse;
import com.afif.paymentapi.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping
	public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest request){
		PaymentResponse response = paymentService.processPayment(request);
		return ResponseEntity.ok(response);
	}
	
}