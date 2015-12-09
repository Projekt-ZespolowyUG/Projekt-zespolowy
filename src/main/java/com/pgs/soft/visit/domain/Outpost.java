package com.pgs.soft.visit.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="outpost")

public class Outpost 
{
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	@Size(min=2, max=20)
	private String name;
	
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
	
	@OneToMany
	private Collection<Employee> employees=new ArrayList<>();
	
	public Outpost() 
	{
		super();
	}
	
	public int getIdOutpost()
	{
		return id;
	}
	public void setIdOutpost(int id)
	{
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Collection<Employee> getEmployees()
	{
		return employees;
	}
	public void setEmployees(Collection<Employee> employees)
	{
		this.employees=employees;
	}

}
