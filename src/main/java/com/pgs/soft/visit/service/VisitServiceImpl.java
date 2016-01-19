package com.pgs.soft.visit.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.domain.Visit;
import com.pgs.soft.visit.dao.*;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitDAO visitDAO;

	public void addVisit(Visit visit) {
		visitDAO.addVisit(visit);

	}

	public List<Visit> getVisits() {
		return visitDAO.getVisits();
	}

	public void updateVisit(Visit outpost) {
		visitDAO.updateVisit(outpost);
	}

	public Visit getVisit(Long id) {
		return visitDAO.getVisit(id);
	}

	public void deleteVisit(Long id) {
		visitDAO.deleteVisit(id);
	}

	public List<Visit> filterVisits(Date startDate, Date endDate) {
		return visitDAO.filterVisits(startDate, endDate);
	}

}