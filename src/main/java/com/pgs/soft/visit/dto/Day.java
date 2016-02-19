package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

public class Day {

	private int dayofweek;
	private int dayofmonth;
	private int month;
	private int year;
	private List<OccupiedTime> occupiedTimeParts = new ArrayList<OccupiedTime>();
	private List<AvailableTime> availableTimeParts = new ArrayList<AvailableTime>();

	public Day() {
	}

	public int getDayofweek() {
		return dayofweek;
	}

	public void setDayofweek(int dayofweek) {
		this.dayofweek = dayofweek;
	}

	public int getDayofmonth() {
		return dayofmonth;
	}

	public void setDayofmonth(int dayofmonth) {
		this.dayofmonth = dayofmonth;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<OccupiedTime> getOccupiedTimeParts() {
		return occupiedTimeParts;
	}

	public void setOccupiedTimeParts(List<OccupiedTime> occupiedTimeParts) {
		this.occupiedTimeParts = occupiedTimeParts;
	}

	public List<AvailableTime> getAvailableTimeParts() {
		return availableTimeParts;
	}

	public void setAvailableTimeParts(List<AvailableTime> availableTimeParts) {
		this.availableTimeParts = availableTimeParts;
	}

	public void addAvailableTime(AvailableTime availabletime) {
		availableTimeParts.add(availabletime);
	}

}
