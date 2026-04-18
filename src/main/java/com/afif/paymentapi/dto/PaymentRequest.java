package com.afif.paymentapi.dto;

public class PaymentRequest {

	private String userId;
	private Double amount;
	private String idempotencyKey;
	
	public PaymentRequest() {
		
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
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}
	
}