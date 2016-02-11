package com.pgs.soft.visit.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.pgs.soft.visit.service.VisitService;
import com.pgs.soft.visit.validation.VisitValidator;

@RestController
@RequestMapping(value = "/visit")
public class VisitController {

	@Autowired
	private VisitService visitService;

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
	public List<Visit> filterVisits(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
			@RequestParam("idEmployee") Long idEmployee, @RequestParam("idCustomer") Long idCustomer) {

		return visitService.filterVisits(startDate, endDate, idEmployee, idCustomer);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void addOutpost(@RequestBody @Valid Visit visit) {

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

}
