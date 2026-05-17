package com.example.Edufinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "admin_entity")
public class Admin_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    
    @Lob
    private String image;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore   // 🔒 PASSWORD SAFE
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "ADMIN";

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin_entity [id=" + id + ", name=" + name + ", image=" + image + ", email=" + email + ", password="
				+ password + ", role=" + role + "]";
	}

	public Admin_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin_entity(Integer id, String name, String image, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	

   
    
}
