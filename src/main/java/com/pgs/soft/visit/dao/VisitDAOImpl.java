package com.pgs.soft.visit.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgs.soft.visit.domain.Visit;

@Repository
public class VisitDAOImpl implements VisitDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addVisit(Visit visit) {
		getCurrentSession().save(visit);
	}

	public void updateVisit(Visit visit) {
		Visit visitToUpdate = getVisit(visit.getId());
		visitToUpdate.setStartDate(visit.getStartDate());
		visitToUpdate.setEndDate(visit.getEndDate());
		visitToUpdate.setEmployee(visit.getEmployee());
		visitToUpdate.setCustomer(visit.getCustomer());
		getCurrentSession().update(visitToUpdate);

	}

	public Visit getVisit(Long id) {
		Visit visit = (Visit) getCurrentSession().get(Visit.class, id);
		return visit;
	}

	public void deleteVisit(Long id) {
		Visit visit = getVisit(id);
		if (visit != null)
			getCurrentSession().delete(visit);
	}

	@SuppressWarnings("unchecked")
	public List<Visit> getVisits() {
		return getCurrentSession().createQuery("from Visit").list();
	}

	@SuppressWarnings("unchecked")
	public List<Visit> filterVisits(Date startDate, Date endDate) {
		String query = "from Visit where startDate='" + startDate + "' or endDate='" + endDate + "'";
		return getCurrentSession().createQuery(query).list();
	}

}