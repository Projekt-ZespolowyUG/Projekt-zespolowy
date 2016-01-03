package com.pgs.soft.visit.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="visit")
public class Visit {

	@Id
	@GeneratedValue
	private
	int id;
	
	@NotEmpty
	
	private
	int idEmployee;
	
	@NotEmpty
	private
	int idCustomer;
	
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private
	 Date date;
	
	 @NotEmpty
	 @Size(min=2, max=20)
	private
	 String time;

	 //Kontruktory
	 public Visit(){
		 super();
	 }
	 
	 //Setters & Getters
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomerFK(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
