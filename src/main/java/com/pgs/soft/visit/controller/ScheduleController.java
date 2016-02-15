package com.pgs.soft.visit.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.service.ScheduleService;
import com.pgs.soft.visit.validation.ScheduleValidator;
import com.pgs.soft.visit.dto.Day;
import com.pgs.soft.visit.dto.ScheduleDTO;
import com.pgs.soft.visit.dto.ScheduleStartDateComparator;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private ScheduleValidator scheduleValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(scheduleValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Schedule> listSchedules() {

		return scheduleService.getSchedules();
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<Schedule> filterSchedules(@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate, @RequestParam("idEmployee") Long idEmployee,
			@RequestParam("idCustomer") Long idCustomer) {

		return scheduleService.filterSchedules(startDate, endDate, idEmployee);
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addOutpost(@RequestBody @Valid Schedule schedule) {

		if (schedule.getId() == null) {

			scheduleService.addSchedule(schedule);
		} else {

			scheduleService.updateSchedule(schedule);
		}
	}

	@RequestMapping(value = "/get/{id}")
	public Schedule getSchedule(@PathVariable("id") Long id) {

		return scheduleService.getSchedule(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteSchedule(@RequestBody @PathVariable("id") Long id) {

		scheduleService.deleteSchedule(id);
	}

	@RequestMapping(value = "/returnSchedules", method = RequestMethod.GET)
	@ResponseBody
	public ScheduleDTO returnSchedules(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
			@RequestParam("idEmployee") Long idEmployee) {
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		List<Schedule> dbschedules = scheduleService.returnSchedules(startDate, endDate, idEmployee);
		
		ScheduleStartDateComparator ssdcomparator = new ScheduleStartDateComparator();
		Collections.sort(dbschedules, ssdcomparator);
		
		List<Day> days = new ArrayList<Day>();

		if (dbschedules.size() != 0) {
			int i = 0;

			Calendar cal = Calendar.getInstance();
			cal.setTime(dbschedules.get(0).getStartDate());
			int currentDay = cal.get(Calendar.DAY_OF_MONTH);

			Day addedDay = new Day();
			addedDay.establishDayofweek(cal.get(Calendar.DAY_OF_WEEK));
			addedDay.setDayofmonth(cal.get(Calendar.DAY_OF_MONTH));
			addedDay.setMonth(cal.get(Calendar.MONTH));
			addedDay.setYear(cal.get(Calendar.YEAR));

			int startHour, startMinute, endHour, endMinute;

			while (i < dbschedules.size()) {
				Schedule dbschedule = dbschedules.get(i);
				cal.setTime(dbschedule.getStartDate());
				int dbDay = cal.get(Calendar.DAY_OF_MONTH);

				if (dbDay == currentDay) {
					cal.setTime(dbschedule.getStartDate());
					startHour = cal.get(Calendar.HOUR_OF_DAY);
					startMinute = cal.get(Calendar.MINUTE);
					cal.setTime(dbschedule.getEndDate());
					endHour = cal.get(Calendar.HOUR_OF_DAY);
					endMinute = cal.get(Calendar.MINUTE);
					addedDay.addMeeting(startHour, startMinute, endHour, endMinute);

				} else {
					days.add(addedDay);
					addedDay = new Day();

					cal.setTime(dbschedule.getStartDate());
					addedDay.establishDayofweek(cal.get(Calendar.DAY_OF_WEEK));
					addedDay.setDayofmonth(cal.get(Calendar.DAY_OF_MONTH));
					addedDay.setMonth(cal.get(Calendar.MONTH));
					addedDay.setYear(cal.get(Calendar.YEAR));

					currentDay = dbDay;

					startHour = cal.get(Calendar.HOUR_OF_DAY);
					startMinute = cal.get(Calendar.MINUTE);
					cal.setTime(dbschedule.getEndDate());
					endHour = cal.get(Calendar.HOUR_OF_DAY);
					endMinute = cal.get(Calendar.MINUTE);
					addedDay.addMeeting(startHour, startMinute, endHour, endMinute);
				}

				i++;

			}
			days.add(addedDay);
			scheduleDTO.setDays(days);
		} else {

		}
		return scheduleDTO;
	}

}
