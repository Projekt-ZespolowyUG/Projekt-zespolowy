package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

import com.pgs.soft.visit.dto.Meeting;

public class Day {

	private String dayofweek;
	private int dayofmonth;
	private int month;
	private int year;
	private List<Meeting> meetings = new ArrayList<Meeting>();

	public Day() {
	}

	public String getDayofweek() {
		return dayofweek;
	}

	public void setDayofweek(String dayofweek) {
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

	public List<Meeting> getList() {
		return meetings;
	}

	public void setList(List<Meeting> list) {
		this.meetings = list;
	}

	public void addMeeting(int startHour, int startMinute, int endHour, int endMinute) {
		Meeting meeting = new Meeting(startHour, startMinute, endHour, endMinute);
		meetings.add(meeting);
	}

	public void establishDayofweek(int Dayofweek) {
		if (Dayofweek == 1) {
			this.dayofweek = "Sunday";
		}
		if (Dayofweek == 2) {
			this.dayofweek = "Monday";
		}
		if (Dayofweek == 3) {
			this.dayofweek = "Tuesday";
		}
		if (Dayofweek == 4) {
			this.dayofweek = "Wednesday";
		}
		if (Dayofweek == 5) {
			this.dayofweek = "Thursday";
		}
		if (Dayofweek == 6) {
			this.dayofweek = "Friday";
		}
		if (Dayofweek == 7) {
			this.dayofweek = "Saturday";
		}
	}

}
