
package com.pgs.soft.visit.dao;

import java.util.Date;
import java.util.List;

import com.pgs.soft.visit.domain.Visit;

public interface VisitDAO {

	public void addVisit(Visit visit);

	public List<Visit> getVisits();

	public List<Visit> filterVisits(Date startDate, Date endDate);

	public void updateVisit(Visit visit);

	public Visit getVisit(Long id);

	public void deleteVisit(Long id);
}