package com.afif.paymentapi.entity;

import jakarta.persistence.*;

@Entity
@Table(
		name = "payments",
		uniqueConstraints = @UniqueConstraint(columnNames = "idempotency_key")
)
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private String userId;
	
	@Column(nullable = false)
	private Double amount;
	
	@Column(name = "idempotency_key", nullable = false, unique = true)
	private String idempotencyKey;

	public Payment() {
		
	}
	
	public Payment(String userId, Double amount, String idempotencyKey) {
		this.userId = userId;
		this.amount = amount;
		this.idempotencyKey = idempotencyKey;
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
	
}