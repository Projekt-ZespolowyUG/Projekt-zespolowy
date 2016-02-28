package com.pgs.soft.visit.dto;

public class DeletedCustomerDTO {
	
	
	public Long id;

	public DeletedCustomerDTO(Long id) {
		this.id = id;

	}

	public Long transferId() {
		return id;
	}

}
