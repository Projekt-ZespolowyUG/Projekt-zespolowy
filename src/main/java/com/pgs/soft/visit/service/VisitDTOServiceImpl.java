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

import com.pgs.soft.visit.dao.ScheduleDAO;
import com.pgs.soft.visit.dao.VisitDAO;
import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.domain.Visit;
import com.pgs.soft.visit.dto.Day;
import com.pgs.soft.visit.dto.OccupiedTime;
import com.pgs.soft.visit.dto.ScheduleStartDateComparator;
import com.pgs.soft.visit.dto.VisitDTO;
import com.pgs.soft.visit.dto.VisitDTODay;

@Service
@Transactional
public class VisitDTOServiceImpl implements VisitDTOService {

	@Autowired
	private ScheduleDAO scheduleDAO;

	@Autowired
	private VisitDAO visitDAO;

	public VisitDTO returnVisitDTO(Date startDate, Date endDate, Long idEmployee, Long idCustomer) {
		VisitDTO visitDTO = new VisitDTO();
		Calendar cal = Calendar.getInstance();
		int i;
		int j;

		cal.setTime(startDate);
		Date modstartDate = new DateTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH), 0, 0).toDate();
		cal.setTime(endDate);
		Date modendDate = new DateTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH), 23, 59).toDate();

		List<Schedule> dbschedules = scheduleDAO.returnSchedules(modstartDate, modendDate, idEmployee);
		ScheduleStartDateComparator ssdcomparator = new ScheduleStartDateComparator();
		Collections.sort(dbschedules, ssdcomparator);

		List<Visit> dbvisits = visitDAO.returnVisits(modstartDate, modendDate, idEmployee);

		List<VisitDTODay> days = new ArrayList<VisitDTODay>();

		Calendar counter = Calendar.getInstance();
		counter.setTime(startDate);
		Calendar ender = Calendar.getInstance();
		ender.setTime(endDate);
		ender.add(Calendar.DATE, 1);// To musi byc, zeby ostani dzien byl brany
									// pod uwage

		while ((counter.get(Calendar.DAY_OF_YEAR) != ender.get(Calendar.DAY_OF_YEAR))
				|| (counter.get(Calendar.YEAR) != ender.get(Calendar.YEAR))) {
			VisitDTODay addedDay = new VisitDTODay();
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
		i=0;
		while (i < dbschedules.size()) {
			Schedule dbschedule = dbschedules.get(i);
			cal.setTime(dbschedule.getStartDate());
			startHour = cal.get(Calendar.HOUR_OF_DAY);
			startMinute = cal.get(Calendar.MINUTE);
			cal.setTime(dbschedule.getEndDate());
			endHour = cal.get(Calendar.HOUR_OF_DAY);
			endMinute = cal.get(Calendar.MINUTE);

			cal.setTime(dbschedule.getStartDate());
			j=0;
			while ((cal.get(Calendar.DAY_OF_YEAR) != days.get(j).getDayofyear())
					|| (cal.get(Calendar.YEAR) != days.get(j).getYear())) {
				j++;
			}
			days.get(j).scheduleToArray(startHour, startMinute, endHour, endMinute);
			i++;

		}
		
		i=0;
		while (i < dbvisits.size()) {
			Visit dbvisit = dbvisits.get(i);
			cal.setTime(dbvisit.getStartDate());
			startHour = cal.get(Calendar.HOUR_OF_DAY);
			startMinute = cal.get(Calendar.MINUTE);
			cal.setTime(dbvisit.getEndDate());
			endHour = cal.get(Calendar.HOUR_OF_DAY);
			endMinute = cal.get(Calendar.MINUTE);

			cal.setTime(dbvisit.getStartDate());
			j=0;
			while ((cal.get(Calendar.DAY_OF_YEAR) != days.get(j).getDayofyear())
					|| (cal.get(Calendar.YEAR) != days.get(j).getYear())) {
				j++;
			}
			days.get(j).visitToArray(startHour, startMinute, endHour, endMinute);
			i++;

		}

		for (i=0;i<days.size();i++)
		{
			days.get(i).arrayToFreeVisits();
		}
		visitDTO.setDays(days);
		return visitDTO;
	}

	public void addVisitDTO(VisitDTO visitdto, Long idEmployee) {

	}

}
