package com.pgs.soft.visit.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgs.soft.visit.domain.Schedule;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addSchedule(Schedule schedule) {
		getCurrentSession().save(schedule);
	}

	public void updateSchedule(Schedule schedule) {

		Schedule scheduleToUpdate = getSchedule(schedule.getId());
		if (scheduleToUpdate != null) {
			scheduleToUpdate.setStartDate(schedule.getStartDate());
			scheduleToUpdate.setEndDate(schedule.getEndDate());
			scheduleToUpdate.setEmployee(schedule.getEmployee());
			getCurrentSession().update(scheduleToUpdate);
		}
	}

	public Schedule getSchedule(Long id) {
		Schedule schedule = (Schedule) getCurrentSession().get(Schedule.class, id);
		return schedule;
	}

	public void deleteSchedule(Long id) {
		Schedule schedule = getSchedule(id);
		if (schedule != null)
			getCurrentSession().delete(schedule);
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> getSchedules() {
		return getCurrentSession().createQuery("from Schedule").list();
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> filterSchedules(Date startDate, Date endDate, Long idEmployee) {
		return getCurrentSession()
				.createQuery("from Schedule where startDate = :startDate or endDate = :endDate "
						+ "idEmployee = :idEmployee")
				.setParameter("firstName", startDate).setParameter("lastName", endDate)
				.setParameter("telephoneNumber", idEmployee).list();

	}

}