package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

public class VisitDTODay {
	
	private int dayofweek;
	private int dayofmonth;
	private int dayofyear;
	private int month;
	private int year;
	
	private List<AvailableTime> freeVisits = new ArrayList<AvailableTime>();

	private boolean[] visitArray = new boolean[1440];
	private boolean[] scheduleArray = new boolean[1440];
	
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
	public int getDayofyear() {
		return dayofyear;
	}
	public void setDayofyear(int dayofyear) {
		this.dayofyear = dayofyear;
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
	public List<AvailableTime> getFreeVisits() {
		return freeVisits;
	}
	public void setFreeVisits(List<AvailableTime> freeVisits) {
		this.freeVisits = freeVisits;
	}
	public boolean[] getVisitArray() {
		return visitArray;
	}
	public void setVisitArray(boolean[] visitArray) {
		this.visitArray = visitArray;
	}
	public boolean[] getScheduleArray() {
		return scheduleArray;
	}
	public void setScheduleArray(boolean[] scheduleArray) {
		this.scheduleArray = scheduleArray;
	}
	
	

}