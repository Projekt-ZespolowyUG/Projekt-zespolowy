package com.pgs.soft.visit.dto;

import java.util.Comparator;

import com.pgs.soft.visit.domain.Schedule;

public class ScheduleStartDateComparator implements Comparator<Schedule> {

	@Override
	public int compare(Schedule schedule1, Schedule schedule2) {
		if (schedule1.getStartDate().after(schedule2.getStartDate())) {
			return 1;
		}
		if (schedule1.getStartDate().before(schedule2.getStartDate())) {
			return -1;
		}
		return 0;
	}

}
