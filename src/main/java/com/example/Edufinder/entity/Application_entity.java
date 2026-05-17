package com.example.Edufinder.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "applications")
public class Application_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName; // 🔥 MATCH DB

    @Column(nullable = false)
    private String email;

    private String phone;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_type")
    private String itemType;

    private String message;

    private String status;

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

    /* ===== AUTO ===== */
    @PrePersist
    public void prePersist() {
        this.appliedAt = LocalDateTime.now();
        if (this.status == null) this.status = "PENDING";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
	}

	@Override
	public String toString() {
		return "Application_entity [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
				+ ", itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", message=" + message
				+ ", status=" + status + ", appliedAt=" + appliedAt + "]";
	}

	public Application_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application_entity(Integer id, String fullName, String email, String phone, Integer itemId, String itemName,
			String itemType, String message, String status, LocalDateTime appliedAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.message = message;
		this.status = status;
		this.appliedAt = appliedAt;
	}

    // getters setters
    
}
