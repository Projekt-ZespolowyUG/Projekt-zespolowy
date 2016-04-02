package com.pgs.soft.visit.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.pgs.soft.visit.domain.Visit;
import com.pgs.soft.visit.dto.ScheduleDTO;
import com.pgs.soft.visit.dto.VisitDTO;
import com.pgs.soft.visit.service.VisitDTOService;
import com.pgs.soft.visit.service.VisitService;
import com.pgs.soft.visit.validation.VisitValidator;

@RestController
@RequestMapping(value = "/visit")
public class VisitController {

	@Autowired
	private VisitService visitService;

	@Autowired
	private VisitDTOService visitDTOService;

	@Autowired
	private VisitValidator visitValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(visitValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Visit> listVisits() {

		return visitService.getVisits();
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<Visit> filterVisits(@RequestParam(value = "startDate", required = false) Date startDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "idEmployee", required = false) Long idEmployee,
			@RequestParam(value = "idCustomer", required = false) Long idCustomer) {

		return visitService.filterVisits(startDate, endDate, idEmployee, idCustomer);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void addVisit(@RequestBody @Valid Visit visit) {

		if (visit.getId() == null) {

			visitService.addVisit(visit);
		} else {

			visitService.updateVisit(visit);
		}
	}

	@RequestMapping(value = "/get/{id}")
	public Visit getVisit(@PathVariable("id") Long id) {

		return visitService.getVisit(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteVisit(@RequestBody @PathVariable("id") Long id) {

		visitService.deleteVisit(id);
	}

	@RequestMapping(value = "/returnvisitdto", method = RequestMethod.GET)
	@ResponseBody
	public VisitDTO returnVisitDTO(@RequestParam("idEmployee") Long idEmployee,
			@RequestParam("idCustomer") Long idCustomer,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate

	) {

		return visitDTOService.returnVisitDTO(startDate, endDate, idEmployee, idCustomer);
	}

	@RequestMapping(value = "/addVisitDto", method = RequestMethod.POST)
	@ResponseBody
	public void addVisitDTO(@RequestParam("idEmployee") Long idEmployee, @RequestParam("idCustomer") Long idCustomer,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date endDate) {
		visitDTOService.addVisitDTO(startDate, endDate, idEmployee, idCustomer);

	}

}
