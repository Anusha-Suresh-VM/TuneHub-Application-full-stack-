package com.example.springboot.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ForgotPassword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String email;
	String token;
	Date expiryDate;
	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ForgotPassword(String email, String token, Date expiryDate) {
		super();
		
		this.email = email;
		this.token = token;
		this.expiryDate = expiryDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "ForgotPassword [id=" + id + ", email=" + email + ", token=" + token + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	

}
