package com.pgs.soft.visit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="schedule")
public class Schedule {

	
	@Id
	@GeneratedValue
	private
	Long id;
	
	@NotNull
	private
	Long idEmployee;
	
	@NotNull
	private
	String startTime;
	
	@NotNull
	private
	String endTime;
	
	
	//Konstruktory
	public Schedule(){
		super();
		
	}
	
	//Setters & Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}