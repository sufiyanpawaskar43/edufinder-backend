package com.example.Edufinder.entity;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.*;

@Entity
@CrossOrigin("*")
@EntityListeners(AuditingEntityListener.class)
public class Institute_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String city;
    private String state;
    private String contact;
    private String email;
    @Lob
    private String description;

    @Column(nullable = false)
    private Double rating = 4.0;
    
    private Double fees;
    
    @Lob
	private String image;
    private String type;   // Coaching / Training / Academy

    @CreatedDate
    private Instant addeddate;

    @LastModifiedDate
    private Instant updateddate;
    @OneToMany(mappedBy = "institute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course_entity> courses;


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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Instant getAddeddate() {
		return addeddate;
	}

	public void setAddeddate(Instant addeddate) {
		this.addeddate = addeddate;
	}

	public Instant getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Instant updateddate) {
		this.updateddate = updateddate;
	}

	@Override
	public String toString() {
		return "Institute_entity [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", contact="
				+ contact + ", email=" + email + ", description=" + description + ", rating=" + rating + ", fees="
				+ fees + ", image=" + image + ", type=" + type + ", addeddate=" + addeddate + ", updateddate="
				+ updateddate + "]";
	}

	public Institute_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Institute_entity(Integer id, String name, String city, String state, String contact, String email,
			String description, Double rating, Double fees, String image, String type, Instant addeddate,
			Instant updateddate) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.contact = contact;
		this.email = email;
		this.description = description;
		this.rating = rating;
		this.fees = fees;
		this.image = image;
		this.type = type;
		this.addeddate = addeddate;
		this.updateddate = updateddate;
	}

	

}