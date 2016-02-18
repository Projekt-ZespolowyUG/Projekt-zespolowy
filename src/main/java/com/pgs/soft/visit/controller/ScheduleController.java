package com.pgs.soft.visit.controller;

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
import com.pgs.soft.visit.service.ScheduleDTOService;
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
	private ScheduleDTOService scheduleDTOService;

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
	public ScheduleDTO returnScheduleDTO(@RequestBody @RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate, @RequestParam("idEmployee") Long idEmployee) {

		return scheduleDTOService.returnScheduleDTO(startDate, endDate, idEmployee);
	}

}
