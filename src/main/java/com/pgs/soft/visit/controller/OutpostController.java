package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.pgs.soft.visit.domain.Outpost;
import com.pgs.soft.visit.service.OutpostService;
import com.pgs.soft.visit.validation.OutpostValidator;

@RestController
@RequestMapping(value = "/outpost")
public class OutpostController {

	@Autowired
	private OutpostService outpostService;

	@Autowired
	private OutpostValidator outpostValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(outpostValidator); 
	}

	//@Produces(MediaType.APPLICATION_JSON)
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Outpost> listOutposts() {

		return outpostService.getOutposts();
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<Outpost> filterOutposts(
			@RequestParam String name,
			@RequestParam String adress,
			@RequestParam String postcode,
			@RequestParam String town,
			@RequestParam String country) {

		
	return outpostService.filterOutposts(name, adress, postcode, town, country);
	}
	@RequestMapping(value = "/get/{id}")
	public Outpost getOutpost(@PathVariable("id") Long id) {

		return outpostService.getOutpost(id);
	}
	
	@RequestMapping(value = "/delete/{id}")
	public void deleteOutpost(@PathVariable("id") Long id) {
		

		outpostService.deleteOutpost(id);
		
		//catch (DataIntegrityViolationException e)
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Outpost addOutpost(@Valid Outpost outpost) {

		if (outpost.getId() == null) {


			outpostService.addOutpost(outpost);
		} else   {

			outpostService.updateOutpost(outpost);
		}

		outpostService.addOutpost(outpost);
		return outpost;

	}
	
	
}
