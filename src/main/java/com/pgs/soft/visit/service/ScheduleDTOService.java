package com.pgs.soft.visit.service;

import java.util.Date;

import com.pgs.soft.visit.dto.ScheduleDTO;
import com.pgs.soft.visit.validation.ServiceForVisitException;

public interface ScheduleDTOService {

	public ScheduleDTO returnScheduleDTO(Date startDate, Date endDate, Long idEmployee);

	public void addScheduleDTO(ScheduleDTO scheduledto, Long idEmployee) throws ServiceForVisitException;

}
