package com.example.Edufinder.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favorites")
public class Favorite_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer itemId;

    private String itemType;

    private LocalDateTime createdAt = LocalDateTime.now();

    // ===== Getters & Setters =====

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

	@Override
	public String toString() {
		return "Favorite_Entity [id=" + id + ", userId=" + userId + ", itemId=" + itemId + ", itemType=" + itemType
				+ ", createdAt=" + createdAt + "]";
	}

	public Favorite_Entity(Integer id, Integer userId, Integer itemId, String itemType, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.itemId = itemId;
		this.itemType = itemType;
		this.createdAt = createdAt;
	}

	public Favorite_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
