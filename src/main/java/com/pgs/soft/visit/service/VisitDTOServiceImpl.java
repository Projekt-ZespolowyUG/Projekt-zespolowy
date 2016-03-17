package com.pgs.soft.visit.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.dto.VisitDTO;

@Service
@Transactional
public class VisitDTOServiceImpl implements VisitDTOService {

	public int toMap(Date date) {
		int mapTime = 0;

		return mapTime;
	}

	public VisitDTO returnVisitDTO(Date startDate, Date endDate, Long idEmployee, Long idCustomer) {
		VisitDTO visitDTO = new VisitDTO();

		return visitDTO;
	}

	public void addVisitDTO(VisitDTO visitdto, Long idEmployee) {

	}

}
