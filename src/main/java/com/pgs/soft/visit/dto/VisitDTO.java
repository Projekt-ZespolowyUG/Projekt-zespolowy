package com.pgs.soft.visit.dto;

import java.util.ArrayList;
import java.util.List;

public class VisitDTO {

	private Long idCustomer;
	private List<Day> days = new ArrayList<Day>();

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

}
