package com.pgs.soft.visit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private long idCustomer;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String firstName;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String lastName;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String telephoneNumber;
	
	
	//Konstruktor
	public Customer(){
	super();
	}
	
	
	//Setters & Getters
	public long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	
}
