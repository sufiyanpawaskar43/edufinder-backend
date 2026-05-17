package com.example.Edufinder.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin("*")
public class College_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String city;
    private String state;
    private String type;      // Private / Government
    private String stream;    // Engineering, Medical, Arts etc
    private Double fees;
    @Lob
    private String description;

    @Column(nullable = false)
    private Double rating = 4.0;

    @Lob
	private String image;

    @CreatedDate
    private Instant addedDate;

    @LastModifiedDate
    private Instant updatedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Instant getAddedDate() {
		return addedDate;
	}
	

	public College_entity(Integer id, String name, String city, String state, String type, String stream, Double fees,
			String description, Double rating, String image, Instant addedDate, Instant updatedDate) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.type = type;
		this.stream = stream;
		this.fees = fees;
		this.description = description;
		this.rating = rating;
		this.image = image;
		this.addedDate = addedDate;
		this.updatedDate = updatedDate;
	}

	public College_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "College_entity [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", type=" + type
				+ ", stream=" + stream + ", fees=" + fees + ", decription=" + description + ", rating=" + rating
				+ ", image=" + image + ", addedDate=" + addedDate + ", updatedDate=" + updatedDate + "]";
	}

	public void setAddedDate(Instant addedDate) {
		this.addedDate = addedDate;
	}

	public Instant getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Instant updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	
}
