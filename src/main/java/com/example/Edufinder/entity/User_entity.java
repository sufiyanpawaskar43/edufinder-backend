package com.example.Edufinder.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@CrossOrigin("*")
@EntityListeners(AuditingEntityListener.class)
public class User_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;
    private String contact;
    private String role;   
    
    private String image;

    @CreatedDate
    private Instant addeddate;

    @LastModifiedDate
    private Instant updateddate;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
		return "User_entity [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", contact="
				+ contact + ", role=" + role + ", image=" + image + ", addeddate=" + addeddate + ", updateddate="
				+ updateddate + "]";
	}

	public User_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_entity(Integer id, String name, String email, String password, String contact, String role,
			String image, Instant addeddate, Instant updateddate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.role = role;
		this.image = image;
		this.addeddate = addeddate;
		this.updateddate = updateddate;
	}

   

	
    
}
