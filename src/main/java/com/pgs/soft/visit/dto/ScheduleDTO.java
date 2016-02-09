 package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;



public class ScheduleDTO {
	
	
	private List<Day> days = new ArrayList<Day>();
	
	public ScheduleDTO() {}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}
	




}

