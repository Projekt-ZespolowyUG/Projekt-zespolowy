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
		while (counter.get(Calendar.DAY_OF_YEAR) != ender.get(Calendar.DAY_OF_YEAR)) {

			Day addedDay = new Day();
			AvailableTime defaultAvailableTime = new AvailableTime(0, 0, 23, 59);
			addedDay.addAvailableTime(defaultAvailableTime);
			addedDay.setDayofweek(counter.get(Calendar.DAY_OF_WEEK));
			// 1-Niedziela, 7-Sobota
			addedDay.setDayofmonth(counter.get(Calendar.DAY_OF_MONTH));
			addedDay.setMonth(counter.get(Calendar.MONTH));
			addedDay.setYear(counter.get(Calendar.YEAR));
			days.add(addedDay);

			counter.add(Calendar.DATE, 1);
		}

		scheduleDTO.setDays(days);
		return scheduleDTO;
	}
}

/*
 * int i = 0;
 * 
 * Calendar cal = Calendar.getInstance();
 * cal.setTime(dbschedules.get(0).getStartDate()); int currentDay =
 * cal.get(Calendar.DAY_OF_MONTH);
 * 
 * Day addedDay = new Day();
 * addedDay.setDayofweek(cal.get(Calendar.DAY_OF_WEEK)); // 1-Niedziela,
 * 7-Sobota addedDay.setDayofmonth(cal.get(Calendar.DAY_OF_MONTH));
 * addedDay.setMonth(cal.get(Calendar.MONTH));
 * addedDay.setYear(cal.get(Calendar.YEAR));
 * 
 * int startHour, startMinute, endHour, endMinute;
 * 
 * while (i < dbschedules.size()) { Schedule dbschedule = dbschedules.get(i);
 * cal.setTime(dbschedule.getStartDate()); int dbDay =
 * cal.get(Calendar.DAY_OF_MONTH);
 * 
 * if (dbDay == currentDay) { cal.setTime(dbschedule.getStartDate()); startHour
 * = cal.get(Calendar.HOUR_OF_DAY); startMinute = cal.get(Calendar.MINUTE);
 * cal.setTime(dbschedule.getEndDate()); endHour =
 * cal.get(Calendar.HOUR_OF_DAY); endMinute = cal.get(Calendar.MINUTE);
 * addedDay.addMeeting(startHour, startMinute, endHour, endMinute);
 * 
 * } else { days.add(addedDay); addedDay = new Day();
 * 
 * cal.setTime(dbschedule.getStartDate());
 * addedDay.establishDayofweek(cal.get(Calendar.DAY_OF_WEEK));
 * addedDay.setDayofmonth(cal.get(Calendar.DAY_OF_MONTH));
 * addedDay.setMonth(cal.get(Calendar.MONTH));
 * addedDay.setYear(cal.get(Calendar.YEAR));
 * 
 * currentDay = dbDay;
 * 
 * startHour = cal.get(Calendar.HOUR_OF_DAY); startMinute =
 * cal.get(Calendar.MINUTE); cal.setTime(dbschedule.getEndDate()); endHour =
 * cal.get(Calendar.HOUR_OF_DAY); endMinute = cal.get(Calendar.MINUTE);
 * addedDay.addMeeting(startHour, startMinute, endHour, endMinute); }
 * 
 * i++;
 * 
 * }
 */
