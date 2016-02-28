package com.pgs.soft.visit.dao;

import java.util.Date;
import java.util.List;

import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.dto.ScheduleDTO;

public interface ScheduleDAO {

	public void addSchedule(Schedule schedule);

	public List<Schedule> getSchedules();

	public List<Schedule> filterSchedules(Date startDate, Date endDate, Long idEmployee);
	
	public List<Schedule> returnSchedules(Date startDate, Date endDate, Long idEmployee);

	public void updateSchedule(Schedule schedule);

	public Schedule getSchedule(Long id);

	public void deleteSchedule(Long id);
	
//	public void addScheduleDTO(ScheduleDTO scheduledto);
}