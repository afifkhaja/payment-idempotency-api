package com.afif.paymentapi.dto;

public class PaymentResponse {

	private Long id;
	private String userId;
	private Double amount;
	private String idempotencyKey;
	private String message;
	
	public PaymentResponse() {
		
	}
	
	public PaymentResponse(Long id, String userId, Double amount, String idempotencyKey, String message) {
		this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.idempotencyKey = idempotencyKey;
		this.message = message;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public String getIdempotencyKey() {
		return idempotencyKey;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}