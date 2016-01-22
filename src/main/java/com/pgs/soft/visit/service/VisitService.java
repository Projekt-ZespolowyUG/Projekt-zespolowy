package com.pgs.soft.visit.service;

import java.util.Date;
import java.util.List;

import com.pgs.soft.visit.domain.Visit;

public interface VisitService {

	public void addVisit(Visit visit);

	public List<Visit> getVisits();

	public List<Visit> filterVisits(Date startDate, Date endDate, Long idEmployee, Long idCustomer);

	public void updateVisit(Visit Visit);

	public Visit getVisit(Long id);

	public void deleteVisit(Long id);
}
