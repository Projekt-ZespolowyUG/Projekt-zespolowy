package com.pgs.soft.visit.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgs.soft.visit.domain.Schedule;
import com.pgs.soft.visit.dto.ScheduleDTO;

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
				.setParameter("startDate", startDate).setParameter("endDate", endDate)
				.setParameter("idEmployee", idEmployee).list();

	}

	@SuppressWarnings("unchecked")
	public List<Schedule> returnSchedules(Date startDate, Date endDate, Long idEmployee) {
		return getCurrentSession()
				.createQuery(
						"from Schedule as s where s.startDate between :startDate and :endDate and s.endDate between :startDate and :endDate and idEmployee = :idEmployee")
				.setParameter("startDate", startDate).setParameter("endDate", endDate)
				.setParameter("idEmployee", idEmployee).list();

	}
	
	public void deleteScheduleDTO(Date startDate, Date endDate, Long idEmployee) {
		getCurrentSession().createQuery("delete from Schedule where startDate between :startDate and :endDate and idEmployee = :idEmployee").setParameter("startDate", startDate).setParameter("endDate", endDate).setParameter("idEmployee", idEmployee);
	}
	


}