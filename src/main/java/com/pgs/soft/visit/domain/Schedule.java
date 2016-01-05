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
	Long idSchedule;
	
	@NotNull
	private
	Long idEmployeeFK;
	
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
	public Long getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(Long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public Long getIdEmployeeFK() {
		return idEmployeeFK;
	}

	public void setIdEmployeeFK(Long idEmployeeFK) {
		this.idEmployeeFK = idEmployeeFK;
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