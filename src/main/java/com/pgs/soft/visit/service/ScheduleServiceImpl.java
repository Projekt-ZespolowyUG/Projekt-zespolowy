package com.pgs.soft.visit.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.dao.*;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDAO scheduleDAO;

	public void addSchedule(Schedule schedule) {
		scheduleDAO.addSchedule(schedule);

	}

	public List<Schedule> getSchedules() {
		return scheduleDAO.getSchedules();
	}

	public void updateSchedule(Schedule outpost) {
		scheduleDAO.updateSchedule(outpost);
	}

	public Schedule getSchedule(Long id) {
		return scheduleDAO.getSchedule(id);
	}

	public void deleteSchedule(Long id) {
		scheduleDAO.deleteSchedule(id);
	}

	public List<Schedule> filterSchedules(Date startDate, Date endDate, Long idEmployee) {
		return scheduleDAO.filterSchedules(startDate, endDate, idEmployee);
	}

	public List<Schedule> returnSchedules(Date startDate, Date endDate, Long idEmployee) {
		return scheduleDAO.returnSchedules(startDate, endDate, idEmployee);
	}

}