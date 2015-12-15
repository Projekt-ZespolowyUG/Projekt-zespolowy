package com.pgs.soft.visit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import com.pgs.soft.visit.validation.Phone;
import com.pgs.soft.visit.validation.Email;



@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String firstName;
	private String lastName;
	@Phone
	private String telephoneNumber;
	@Column(unique=true)
	@Email
	private String email;
	private String adress;
	private String postcode;
	private String town;
	private String country;
	
 @ManyToOne
@JoinColumn(name="idOutpost")
	private Outpost outpost; 
 
 @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)  
	private User user;

	
	
	
	//Kontruktor
	public Employee() {
		super();
	}
	
	//Setters & Getters
	public int getIdEmployee() {
		return id;
	}
	public void setIdEmployee(int id) {
		this.id = id;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	 public Outpost getOutpost()
	{
		return outpost;
	}
	public void setOutpost(Outpost outpost)
	{
		this.outpost=outpost;
	} 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
