package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDTO {

	private Long idEmployee;
	private List<Day> days = new ArrayList<Day>();

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	

}
