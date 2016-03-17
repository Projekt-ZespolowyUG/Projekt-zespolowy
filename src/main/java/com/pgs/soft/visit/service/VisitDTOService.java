package com.pgs.soft.visit.service;

import java.util.Date;

import com.pgs.soft.visit.dto.VisitDTO;

public interface VisitDTOService {

	public int toMap(Date date);
	
	public VisitDTO returnVisitDTO(Date startDate, Date endDate, Long idEmployee, Long idCustomer);

	public void addVisitDTO(VisitDTO visitdto, Long idEmployee);
}