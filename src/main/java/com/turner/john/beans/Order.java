package com.turner.john.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Allows for the table to be created as an entity
@Entity
@Table(name = "orders")
public class Order {

	//Generates an ID number for the order
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String transactionDate;
	
	
	//Allows the user and product to be combined in a table for the order
	@OneToOne(optional=false)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(optional=false)
	@JoinColumn(name="product_id")
	private Product product;

	//Getters and setters along with the hashcode
	public Order(Product product, User user){
		this.product = product;
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order() {
		
	}

	public Order(long id){
		this.id=id;
	}

	
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
