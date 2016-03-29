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

	private boolean[] scheduleArray = new boolean[1440];
	
	public void scheduleToArray(int startHour, int startMinute, int endHour, int endMinute)
	{
		int i;
		for (i=startHour*60+startMinute;i<endHour*60+endMinute;i++)
		{
			scheduleArray[i]=true;
		}
	}
	
	public void visitToArray(int startHour, int startMinute, int endHour, int endMinute)
	{
		int i;
		for (i=startHour*60+startMinute;i<endHour*60+endMinute;i++)
		{
			scheduleArray[i]=false;
		}
	}
	
	public void arrayToFreeVisits()
	{
		int i;
		int startHour, startMinute, endHour, endMinute;
		boolean loadingFreeVisit=false;
		for (i=0;i<1440;i++)
		{
			if(loadingFreeVisit==false && scheduleArray[i]==true)
			{
				startHour=i/60;
				startMinute=i%60;
				loadingFreeVisit=true;
			}
			else if (loadingFreeVisit==true)
			{
				
			}
		}
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
	public boolean[] getScheduleArray() {
		return scheduleArray;
	}
	public void setScheduleArray(boolean[] scheduleArray) {
		this.scheduleArray = scheduleArray;
	}
	
	

}
