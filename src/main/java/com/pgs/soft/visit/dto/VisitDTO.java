package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

public class VisitDTO {

	private Long idCustomer;
	private List<VisitDTODay> days = new ArrayList<VisitDTODay>();

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public List<VisitDTODay> getDays() {
		return days;
	}

	public void setDays(List<VisitDTODay> days) {
		this.days = days;
	}

}