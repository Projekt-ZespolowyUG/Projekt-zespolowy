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
	long idVisit;
	
	@NotEmpty
	
	private
	long idEmployeeFK;
	
	@NotEmpty
	private
	long idCustomerFK;
	
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
	public long getIdVisit() {
		return idVisit;
	}

	public void setIdVisit(long idVisit) {
		this.idVisit = idVisit;
	}

	public long getIdEmployeeFK() {
		return idEmployeeFK;
	}

	public void setIdEmployeeFK(long idEmployeeFK) {
		this.idEmployeeFK = idEmployeeFK;
	}

	public long getIdCustomerFK() {
		return idCustomerFK;
	}

	public void setIdCustomerFK(long idCustomerFK) {
		this.idCustomerFK = idCustomerFK;
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
