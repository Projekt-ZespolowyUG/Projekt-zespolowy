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
import com.pgs.soft.visit.dao.EmployeeDAO;
import com.pgs.soft.visit.dao.ScheduleDAO;
import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.dto.ScheduleDTO;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes=WebAppConfig.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@Transactional
@WebAppConfiguration
public class ScheduleDTOServiceTest {

	// @Autowired
	// ApplicationContext applicationcontext;

	@Autowired
	ScheduleDTOService scheduleDTOService;

	@Autowired
	ScheduleDAO scheduleDAO;

	@Autowired
	EmployeeDAO employeeDAO;

	private final Date dateStart = new DateTime(2015, 1, 15, 12, 0).toDate();
	private final Date dateEnd = new DateTime(2015, 1, 20, 12, 0).toDate();
	
	private final Date date1 = new DateTime(2015, 1, 16, 12, 0).toDate();
	private final Date date2 = new DateTime(2015, 1, 16, 13, 30).toDate();
	private final Date date3 = new DateTime(2015, 1, 16, 14, 0).toDate();
	private final Date date4 = new DateTime(2015, 1, 16, 15, 30).toDate();

	@Test
	public void numberofdaysCheck() {
		Long id1 = employeeDAO.getEmployees().get(0).getId();
		ScheduleDTO scheduledto = scheduleDTOService.returnScheduleDTO(dateStart, dateEnd, id1);
		assertEquals(scheduledto.getDays().size(), 6);
	}

	@Test
	public void availableCheck() {
		Long id1 = employeeDAO.getEmployees().get(0).getId();
		
		Schedule schedule1 = new Schedule();
		schedule1.setStartDate(date1);
		schedule1.setEndDate(date2);
		schedule1.setEmployee(employeeDAO.getEmployees().get(0));
		scheduleDAO.addSchedule(schedule1);
		
		Schedule schedule2 = new Schedule();
		schedule2.setStartDate(date3);
		schedule2.setEndDate(date4);
		schedule2.setEmployee(employeeDAO.getEmployees().get(0));
		scheduleDAO.addSchedule(schedule2);
		
		ScheduleDTO scheduledto = scheduleDTOService.returnScheduleDTO(dateStart, dateEnd, id1);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().size(), 3);
		assertEquals(scheduledto.getDays().get(1).getOccupiedTimeParts().size(), 2);
		assertEquals(scheduledto.getDays().get(2).getOccupiedTimeParts().size(), 0);
		assertEquals(scheduledto.getDays().get(2).getAvailableTimeParts().size(), 1);
		
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(0).getStartHour(), 0);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(0).getStartMinute(), 0);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(0).getEndHour(), 12);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(0).getEndMinute(), 0);
		
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(1).getStartHour(), 13);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(1).getStartMinute(), 30);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(1).getEndHour(), 14);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(1).getEndMinute(), 0);
		
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(2).getStartHour(), 15);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(2).getStartMinute(), 30);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(2).getEndHour(), 23);
		assertEquals(scheduledto.getDays().get(1).getAvailableTimeParts().get(2).getEndMinute(), 59);
		
	}

}
