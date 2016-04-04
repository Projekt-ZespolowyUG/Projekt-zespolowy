package com.pgs.soft.visit.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.service.ScheduleDTOService;
import com.pgs.soft.visit.service.ScheduleService;
import com.pgs.soft.visit.validation.ScheduleForVisitException;
import com.pgs.soft.visit.dto.ScheduleDTO;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private ScheduleDTOService scheduleDTOService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Schedule> listSchedules() {

		return scheduleService.getSchedules();
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<Schedule> filterSchedules(@RequestParam(value = "startDate", required = false) Date startDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "idEmployee", required = false) Long idEmployee) {

		return scheduleService.filterSchedules(startDate, endDate, idEmployee);
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addSchedule(@RequestBody @Valid Schedule schedule) {

		if (schedule.getId() == null) {

			scheduleService.addSchedule(schedule);
		} else {

			scheduleService.updateSchedule(schedule);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/addScheduleDTO", method = RequestMethod.POST)
	public void addSchedule(@RequestBody ScheduleDTO scheduledto) throws ScheduleForVisitException {

		scheduleDTOService.addScheduleDTO(scheduledto);
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
	public ScheduleDTO returnScheduleDTO(@RequestParam("idEmployee") Long idEmployee,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate

	) {

		return scheduleDTOService.returnScheduleDTO(startDate, endDate, idEmployee);
	}

}
