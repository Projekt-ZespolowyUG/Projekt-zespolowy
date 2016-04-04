package com.pgs.soft.visit.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pgs.soft.visit.domain.Schedule;

@Component
public class ScheduleValidator implements Validator {
	@Override
	public boolean supports(Class<?> paramClass) {
		return Schedule.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Schedule schedule = (Schedule) obj;
		if (schedule.getEmployee() == null) {
			errors.rejectValue("employee", "empty");
		}
		if (schedule.getStartDate() == null) {
			errors.rejectValue("startdate", "empty");
		}
		if (schedule.getEndDate() == null) {
			errors.rejectValue("enddate", "empty");
		}
		if (schedule.getEndDate().before(schedule.getStartDate())) {
			errors.rejectValue("enddate", "enddate");
		}
	}
}