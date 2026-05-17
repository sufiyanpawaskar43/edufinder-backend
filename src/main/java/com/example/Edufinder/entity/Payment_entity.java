package com.example.Edufinder.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer applicationId;

    @Column(nullable = false)
    private Double amount;

    @Column(unique = true)
    private String razorpayOrderId;

    private String razorpayPaymentId;

    private String status; // CREATED / PAID / FAILED

    private LocalDateTime createdAt = LocalDateTime.now();

    // ===== Constructors =====
    public Payment_entity() {}

    // ===== Getters & Setters =====
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public String getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

	@Override
	public String toString() {
		return "Payment_entity [id=" + id + ", applicationId=" + applicationId + ", amount=" + amount
				+ ", razorpayOrderId=" + razorpayOrderId + ", razorpayPaymentId=" + razorpayPaymentId + ", status="
				+ status + ", createdAt=" + createdAt + "]";
	}

	public Payment_entity(Integer id, Integer applicationId, Double amount, String razorpayOrderId,
			String razorpayPaymentId, String status, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.applicationId = applicationId;
		this.amount = amount;
		this.razorpayOrderId = razorpayOrderId;
		this.razorpayPaymentId = razorpayPaymentId;
		this.status = status;
		this.createdAt = createdAt;
	}
    
    
}
