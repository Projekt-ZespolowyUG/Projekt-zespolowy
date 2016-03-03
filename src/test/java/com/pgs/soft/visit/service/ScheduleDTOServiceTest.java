package com.pgs.soft.visit.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.init.Initializer;
import com.pgs.soft.visit.init.WebAppConfig;

import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.dto.ScheduleDTO;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=WebAppConfig.class)
@ContextConfiguration(classes={WebAppConfig.class })
@Transactional
@WebAppConfiguration
public class ScheduleDTOServiceTest {

	
//	@Autowired
//	ApplicationContext applicationcontext;
	
	@Autowired
	ScheduleDTOService scheduleDTOService;
	
	@Autowired
	ScheduleService sheduleService;
	
	@Autowired
	EmployeeService employeeService;
	
	private final Date date1 = new DateTime(2015, 1, 15, 12, 0).toDate();
	private final Date date2 = new DateTime(2015, 1, 20, 12, 0).toDate();
	private final Long tid = Integer.toUnsignedLong(3);
	
	
	@Test
	public void numberofdaysCheck()
	{
		Long id1 = employeeService.getEmployees().get(0).getId();
//		ScheduleDTO scheduledto = scheduleDTOService.returnScheduleDTO(date1, date2, id1);
//		assertEquals(scheduledto.getDays().size(), 6);
		assertEquals(tid, id1);
	}
	
//	Schedule schedule1 = new Schedule();
//	schedule1.setStartDate(date1);
//	schedule1.setEndDate(date2);
//	schedule1.setEmployee(employeeservice.getEmployees().get(0));
}
