package com.pgs.soft.visit.service;

import java.util.Date;

import com.pgs.soft.visit.dto.VisitDTO;

public class VisitDTOServiceImpl implements VisitDTOService {

	public VisitDTO returnVisitDTO(Date startDate, Date endDate, Long idEmployee, Long idCustomer) {
		VisitDTO visitDTO = new VisitDTO();

		return visitDTO;
	}

	public void addVisitDTO(VisitDTO visitdto, Long idEmployee) {

	}

}
