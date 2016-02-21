package com.pgs.soft.visit.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.dao.ScheduleDAO;
import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.dto.AvailableTime;
import com.pgs.soft.visit.dto.Day;
import com.pgs.soft.visit.dto.OccupiedTime;
import com.pgs.soft.visit.dto.ScheduleDTO;
import com.pgs.soft.visit.dto.ScheduleStartDateComparator;

@Service
@Transactional
public class ScheduleDTOServiceImpl implements ScheduleDTOService {

	@Autowired
	private ScheduleDAO scheduleDAO;

	ScheduleDTO scheduleDTO = new ScheduleDTO();

	public ScheduleDTO returnScheduleDTO(Date startDate, Date endDate, Long idEmployee) {

		List<Schedule> dbschedules = scheduleDAO.returnSchedules(startDate, endDate, idEmployee);
		ScheduleStartDateComparator ssdcomparator = new ScheduleStartDateComparator();
		Collections.sort(dbschedules, ssdcomparator);

		ScheduleDTO scheduleDTO = new ScheduleDTO();
		List<Day> days = new ArrayList<Day>();

		Calendar counter = Calendar.getInstance();
		counter.setTime(startDate);
		Calendar ender = Calendar.getInstance();
		ender.setTime(endDate);
		ender.add(Calendar.DATE, 1);// To musi byc, zeby ostani dzien byl brany
									// pod uwage

		while ((counter.get(Calendar.DAY_OF_YEAR) != ender.get(Calendar.DAY_OF_YEAR))
				|| (counter.get(Calendar.YEAR) != ender.get(Calendar.YEAR))) {

			Day addedDay = new Day();
			AvailableTime defaultAvailableTime = new AvailableTime(0, 0, 23, 59);
			addedDay.addAvailableTime(defaultAvailableTime);
			addedDay.setDayofweek(counter.get(Calendar.DAY_OF_WEEK));
			// 1-Niedziela, 7-Sobota
			addedDay.setDayofmonth(counter.get(Calendar.DAY_OF_MONTH));
			addedDay.setDayofyear(counter.get(Calendar.DAY_OF_YEAR));
			addedDay.setMonth(counter.get(Calendar.MONTH));
			addedDay.setYear(counter.get(Calendar.YEAR));
			days.add(addedDay);

			counter.add(Calendar.DATE, 1);
		}

		Calendar cal = Calendar.getInstance();
		int startHour, startMinute, endHour, endMinute;
		int i = 0;

		while (i < dbschedules.size()) {
			Schedule dbschedule = dbschedules.get(i);
			cal.setTime(dbschedule.getStartDate());
			startHour = cal.get(Calendar.HOUR_OF_DAY);
			startMinute = cal.get(Calendar.MINUTE);
			cal.setTime(dbschedule.getEndDate());
			endHour = cal.get(Calendar.HOUR_OF_DAY);
			endMinute = cal.get(Calendar.MINUTE);

			OccupiedTime addedoccupiedtime = new OccupiedTime(startHour, startMinute, endHour, endMinute);
			cal.setTime(dbschedule.getStartDate());

			int j = 0;
			while ((cal.get(Calendar.DAY_OF_YEAR) != days.get(j).getDayofyear())
					|| (cal.get(Calendar.YEAR) != days.get(j).getYear())) {
				j++;
			}
			days.get(j).addOccupiedTime(addedoccupiedtime);

		}

		i = 0;
		while (i < days.size()) {
			days.get(i).establishAvailableTimeParts();

		}
		scheduleDTO.setDays(days);
		return scheduleDTO;
	}
}