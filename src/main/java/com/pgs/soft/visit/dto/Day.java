package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

public class Day {

	private int dayofweek;
	private int dayofmonth;
	private int dayofyear;
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

	public int getDayofyear() {
		return dayofyear;
	}

	public void setDayofyear(int dayofyear) {
		this.dayofyear = dayofyear;
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

	public void addOccupiedTime(OccupiedTime occupiedtime) {
		occupiedTimeParts.add(occupiedtime);
	}

	public void establishAvailableTimeParts() {
		if (occupiedTimeParts.size() == 0) {

		} else {
			availableTimeParts.remove(0);

			AvailableTime firstavailabletime = new AvailableTime(0, 0, occupiedTimeParts.get(0).getStartHour(),
					occupiedTimeParts.get(0).getStartMinute());
			if (firstavailabletime.getStartHour() != firstavailabletime.getEndHour()
					|| firstavailabletime.getStartMinute() != firstavailabletime.getEndMinute()) {
				availableTimeParts.add(firstavailabletime);
			}
			for (int i = 0; i < occupiedTimeParts.size() - 1; i++) {
				AvailableTime availabletime = new AvailableTime(occupiedTimeParts.get(i).getEndHour(),
						occupiedTimeParts.get(i).getEndMinute(), occupiedTimeParts.get(i + 1).getStartHour(),
						occupiedTimeParts.get(i + 1).getStartMinute());
				if (availabletime.getStartHour() != availabletime.getEndHour()
						|| availabletime.getStartMinute() != availabletime.getEndMinute()) {
					availableTimeParts.add(availabletime);
				}
			}
			AvailableTime lastavailabletime = new AvailableTime(
					occupiedTimeParts.get(occupiedTimeParts.size() - 1).getEndHour(),
					occupiedTimeParts.get(occupiedTimeParts.size() - 1).getEndMinute(), 23, 59);
			if (lastavailabletime.getStartHour() != lastavailabletime.getEndHour()
					|| lastavailabletime.getStartMinute() != lastavailabletime.getEndMinute()) {
				availableTimeParts.add(lastavailabletime);
			}

		}
	}

}
