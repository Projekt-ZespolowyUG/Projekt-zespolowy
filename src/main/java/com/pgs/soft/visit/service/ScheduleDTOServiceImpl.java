package com.pgs.soft.visit.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.dao.EmployeeDAO;
import com.pgs.soft.visit.dao.ScheduleDAO;
import com.pgs.soft.visit.dao.VisitDAO;
import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.domain.Visit;
import com.pgs.soft.visit.dto.AvailableTime;
import com.pgs.soft.visit.dto.Day;
import com.pgs.soft.visit.dto.OccupiedTime;
import com.pgs.soft.visit.dto.ScheduleDTO;
import com.pgs.soft.visit.dto.ScheduleStartDateComparator;
import com.pgs.soft.visit.validation.ScheduleForVisitException;

@Service
@Transactional
public class ScheduleDTOServiceImpl implements ScheduleDTOService {

	@Autowired
	private ScheduleDAO scheduleDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private VisitDAO visitDAO;

	public void addScheduleDTO(ScheduleDTO scheduledto) throws ScheduleForVisitException {
		Day firstDay = scheduledto.getDays().get(0);
		Day lastDay = scheduledto.getDays().get(scheduledto.getDays().size() - 1);

		Date startDate = new DateTime(firstDay.getYear(), firstDay.getMonth(), firstDay.getDayofmonth(), 0, 0).toDate();
		Date endDate = new DateTime(lastDay.getYear(), lastDay.getMonth(), lastDay.getDayofmonth(), 23, 59).toDate();

		int i;
		int j;
		int h;

		boolean isSchedule;
		boolean isStart;
		boolean isEnd;
		boolean scheduleForVisitException = false;
		int visitYear;
		int visitDayOfYear;
		int visitStartHour;
		int visitStartMinute;
		int visitEndHour;
		int visitEndMinute;
		List<Visit> visits = visitDAO.returnVisits(startDate, endDate, scheduledto.getIdEmployee());
		
//		for (Visit visit : visits) {
//			
//			
//		}
		
		Calendar visitcal = Calendar.getInstance();
		//for (int i = 0...)
		for (i = 0; i < visits.size(); i++) {
			isSchedule = false;
			visitcal.setTime(visits.get(i).getStartDate());
			visitYear = visitcal.get(Calendar.YEAR);
			visitDayOfYear = visitcal.get(Calendar.DAY_OF_YEAR);
			visitStartHour = visitcal.get(Calendar.HOUR_OF_DAY);
			visitStartMinute = visitcal.get(Calendar.MINUTE);
			visitcal.setTime(visits.get(i).getEndDate());
			visitEndHour = visitcal.get(Calendar.HOUR_OF_DAY);
			visitEndMinute = visitcal.get(Calendar.MINUTE);

			for (j = 0; j < scheduledto.getDays().size(); j++) {
				if (visitYear == scheduledto.getDays().get(j).getYear()
						&& visitDayOfYear == scheduledto.getDays().get(j).getDayofyear()) {
					for (h = 0; h < scheduledto.getDays().get(j).getOccupiedTimeParts().size(); h++) {
						OccupiedTime occupiedTime = scheduledto.getDays().get(j).getOccupiedTimeParts().get(h);
						isStart = false;
						isEnd = false;
						if (visitStartHour > occupiedTime.getStartHour()) {
							isStart = true;
						} else {
							if (visitStartHour == occupiedTime.getStartHour()
									&& visitStartMinute >= occupiedTime.getStartMinute()) {
								isStart = true;
							}
						}
						if (visitEndHour < occupiedTime.getEndHour()) {
							isEnd = true;
						} else {
							if (visitEndHour == occupiedTime.getEndHour()
									&& visitEndMinute <= occupiedTime.getEndMinute()) {
								isEnd = true;
							}
						}
						if (isStart == true && isEnd == true) {
							isSchedule = true;
						}
					}
				}
			}
			if (isSchedule == false) {
				scheduleForVisitException = true;
			}
		}

		if (scheduleForVisitException == false) {
			scheduleDAO.deleteScheduleDTO(startDate, endDate, scheduledto.getIdEmployee());
			for (i = 0; i < scheduledto.getDays().size(); i++) {
				Day day = scheduledto.getDays().get(i);
				for (j = 0; j < day.getOccupiedTimeParts().size(); j++) {
					Schedule schedule = new Schedule();
					Date date1 = new DateTime(day.getYear(), day.getMonth(), day.getDayofmonth(),
							day.getOccupiedTimeParts().get(j).getStartHour(),
							day.getOccupiedTimeParts().get(j).getStartMinute()).toDate();
					schedule.setStartDate(date1);
					Date date2 = new DateTime(day.getYear(), day.getMonth(), day.getDayofmonth(),
							day.getOccupiedTimeParts().get(j).getEndHour(),
							day.getOccupiedTimeParts().get(j).getEndMinute()).toDate();
					schedule.setEndDate(date2);
					schedule.setEmployee(employeeDAO.getEmployee(scheduledto.getIdEmployee()));

					scheduleDAO.addSchedule(schedule);

				}
			}
		} else {
			throw new ScheduleForVisitException();

		}

	}

	public ScheduleDTO returnScheduleDTO(Date startDate, Date endDate, Long idEmployee) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		Date modstartDate = new DateTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH), 0, 0).toDate();
		cal.setTime(endDate);
		Date modendDate = new DateTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH), 23, 59).toDate();
		List<Schedule> dbschedules = scheduleDAO.returnSchedules(modstartDate, modendDate, idEmployee);
		ScheduleStartDateComparator ssdcomparator = new ScheduleStartDateComparator();
		Collections.sort(dbschedules, ssdcomparator);

		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setIdEmployee(idEmployee);
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
			addedDay.setMonth(counter.get(Calendar.MONTH) + 1);
			addedDay.setYear(counter.get(Calendar.YEAR));
			days.add(addedDay);

			counter.add(Calendar.DATE, 1);
		}

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
			i++;

		}

		i = 0;
		while (i < days.size()) {
			days.get(i).establishAvailableTimeParts();
			if(days.get(i).getOccupiedTimeParts().size()==0)
			{
				OccupiedTime defaultOccupiedTime = new OccupiedTime(0, 0, 0, 0);
				days.get(i).getOccupiedTimeParts().add(defaultOccupiedTime);
			}
			i++;

		}
		scheduleDTO.setDays(days);
		return scheduleDTO;
	}
}
