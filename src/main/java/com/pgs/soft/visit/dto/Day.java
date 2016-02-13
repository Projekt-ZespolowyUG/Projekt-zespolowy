package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

import com.pgs.soft.visit.dto.Meeting;

public class Day {

	private String day;
	private List<Meeting> meetings = new ArrayList<Meeting>();

	public Day() {
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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

}
