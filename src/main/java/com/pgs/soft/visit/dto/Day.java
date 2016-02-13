package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

import com.pgs.soft.visit.domain.Schedule;

public class Day {

	private String day;
	private List<Schedule> list = new ArrayList<Schedule>();

	public Day() {
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<Schedule> getList() {
		return list;
	}

	public void setList(List<Schedule> list) {
		this.list = list;
	}

}
