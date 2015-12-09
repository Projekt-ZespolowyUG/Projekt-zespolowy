package com.pgs.soft.visit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String firstName;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String lastName;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String telephoneNumber;
	
	//email dodac
	
	@NotEmpty
	@Size(min=2, max=20)
	private String adress;
	
	@NotEmpty
	@Size(min=6, max=6)
	private String postcode;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String town;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String country;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Outpost outpost;
	
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

}
