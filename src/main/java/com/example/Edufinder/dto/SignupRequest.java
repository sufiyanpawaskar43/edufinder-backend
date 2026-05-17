package com.example.Edufinder.dto;

public class SignupRequest {

    private String name;
    private String email;
    private String password;
    private String contact;
    private String role;

   
    public SignupRequest(String name, String email, String password, String contact, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.role = role;
	}
	public SignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SignupRequest [name=" + name + ", email=" + email + ", password=" + password + ", contact=" + contact
				+ ", role=" + role + "]";
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
}
