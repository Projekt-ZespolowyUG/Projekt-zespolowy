package com.pgs.soft.visit.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.dto.ScheduleDTO;

public class ScheduleDTOServiceTest {
	
	@Autowired
	ScheduleDTOService scheduleDTOService;
	
	@Autowired
	ScheduleService sheduleService;
	
	@Autowired
	EmployeeService employeeService;
	
	private final Date date1 = new DateTime(2015, 1, 15, 12, 0).toDate();
	private final Date date2 = new DateTime(2015, 1, 20, 12, 0).toDate();
	
	
	@Test
	public void numberofdaysCheck()
	{
		Long id1 = employeeService.getEmployees().get(0).getId();
		ScheduleDTO scheduledto = scheduleDTOService.returnScheduleDTO(date1, date2, id1);
		assertEquals(scheduledto.getDays().size(), 6);
	}
	
//	Schedule schedule1 = new Schedule();
//	schedule1.setStartDate(date1);
//	schedule1.setEndDate(date2);
//	schedule1.setEmployee(employeeservice.getEmployees().get(0));
}
