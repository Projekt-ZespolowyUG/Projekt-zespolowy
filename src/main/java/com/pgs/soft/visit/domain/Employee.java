package main.java.com.collaborative_project.domain;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private long idEmployee;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String telephoneNumber;
	
	@NotEmpty
	private String adress;
	
	@NotEmpty
	@Size(min=6, max=6)
	private String postcode;
	
	@NotEmpty
	private String town;
	
	@NotEmpty
	private String country;
	
	//Kontruktor
	public Employee(long idEmployee, String firstName, String lastName, String telephoneNumber, String adress, String postcode, String town, String country) {
		
		setIdEmployee(idEmployee);	
		setFirstName(firstName);
		setLastName(lastName);
		setTelephoneNumber(telephoneNumber);
		setAdress(adress);
		setPostcode(postcode);
		setTown(town);
		setCountry(country);
	}
	
	//Setters & Getters
	public long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
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
	

}