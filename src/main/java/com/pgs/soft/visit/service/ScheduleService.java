package com.pgs.soft.visit.service;

import java.util.Date;
import java.util.List;

import com.pgs.soft.visit.domain.Schedule;

public interface ScheduleService {

	public void addSchedule(Schedule schedule);

	public List<Schedule> getSchedules();

	public List<Schedule> filterSchedules(Date startDate, Date endDate, Long idEmployee);

	public List<Schedule> returnSchedules(Date startDate, Date endDate, Long idEmployee);

	public void updateSchedule(Schedule Schedule);

	public Schedule getSchedule(Long id);

	public void deleteSchedule(Long id);
}