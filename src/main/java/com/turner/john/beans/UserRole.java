package com.turner.john.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//User role table is created for the user class
@Entity
@Table(name = "user_roles")
public class UserRole {

	//ID's are generated for User roles along with their properties
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long userId;
	private String role;
	public long getUserId(){
		return userId;
		
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public UserRole(long userId){
		this.userId = userId;
		role = "USER";
	}
}
