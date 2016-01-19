package com.pgs.soft.visit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.pgs.soft.visit.domain.Outpost;
import com.pgs.soft.visit.service.OutpostService;
import com.pgs.soft.visit.validation.OutpostValidator;

@Controller
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

		List<Outpost> source = outpostService.getOutposts();
		List<Outpost> outcome = new ArrayList<Outpost>();
		
		for (int i = 0; i < source.size(); i++) {
			Outpost o = source.get(i);
			if( o.getName().equals(name) )
			{
				outcome.add(o);
			}
			else if( o.getAdress().equals(adress) )
			{
				outcome.add(o);
			}
			else if( o.getTown().equals(town) )
			{
				outcome.add(o);
			}
			else if( o.getPostcode().equals(postcode) )
			{
				outcome.add(o);
			}
			else if( o.getCountry().equals(country) )
			{
				outcome.add(o);
			}
		}
		return outcome;
	}
	@RequestMapping(value = "/get/{id}")
	public Outpost getOutpost(@PathVariable("id") Long id) {

		return outpostService.getOutpost(id);
	}
	
	@RequestMapping(value = "/delete/{id}")
	public void deleteOutpost(@PathVariable("id") Long id) {

		outpostService.deleteOutpost(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addOutpost(@ModelAttribute @Valid Outpost outpost) {

		if (outpost.getId() == null) {


			outpostService.addOutpost(outpost);
		} else {

			outpostService.updateOutpost(outpost);
		}
		outpostService.addOutpost(outpost);

	}
	
	
}
