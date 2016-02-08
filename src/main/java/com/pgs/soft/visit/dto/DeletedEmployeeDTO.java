package com.pgs.soft.visit.dto;

public class DeletedEmployeeDTO {
	Long id;

	public DeletedEmployeeDTO(Long id) {
		this.id = id;

	}

	public Long transferId() {
		return id;
	}

}
