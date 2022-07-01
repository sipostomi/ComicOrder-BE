package com.siposnet.comics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="pieces")
	private int pieces;

	public Order() {}
	
	public Order(String name, String email, String address, String phoneNumber, int pieces) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.pieces = pieces;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", pieces=" + pieces + "]";
	}
	
	
	
	
	
}
