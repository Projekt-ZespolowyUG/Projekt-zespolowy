package com.pgs.soft.visit.service;

import java.util.Date;

import com.pgs.soft.visit.dto.ScheduleDTO;

public interface ScheduleDTOService {

	public ScheduleDTO returnScheduleDTO(Date startDate, Date endDate, Long idEmployee);

}
