package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.pgs.soft.visit.domain.Outpost;
import com.pgs.soft.visit.dto.DeletedOutpostDTO;
import com.pgs.soft.visit.service.OutpostService;
import com.pgs.soft.visit.validation.DeletedOutpostValidator;
import com.pgs.soft.visit.validation.OutpostValidator;
import com.pgs.soft.visit.validation.ReferenceToDeletedOutpostException;

@RestController
@RequestMapping(value = "/outpost")
public class OutpostController {

	@Autowired
	private OutpostService outpostService;

	@Autowired
	private OutpostValidator outpostValidator;
	
	@Autowired
	private DeletedOutpostValidator deletedoutpostvalidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(outpostValidator); 
	}


	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Outpost> listOutposts() {

		return outpostService.getOutposts();
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<Outpost> filterOutposts(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "adress", required = false) String adress,
			@RequestParam(value = "postcode", required = false) String postcode,
			@RequestParam(value = "town", required = false) String town,
			@RequestParam(value = "country", required = false) String country) {

		
	return outpostService.filterOutposts(name, adress, postcode, town, country);
	}
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Outpost getOutpost(@PathVariable("id") Long id) {

		return outpostService.getOutpost(id);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteOutpost(@RequestBody @PathVariable("id") Long id) 
		throws ReferenceToDeletedOutpostException {
		DeletedOutpostDTO deletedoutpost = new DeletedOutpostDTO(id);
		
		BindException errors = new BindException(deletedoutpost, DeletedOutpostDTO.class.getName());
		deletedoutpostvalidator.validate(deletedoutpost, errors);
		

		if (errors.hasErrors()) {
			throw new ReferenceToDeletedOutpostException();
		} else {
			outpostService.deleteOutpost(deletedoutpost.getId());
		}

	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Outpost addOutpost(@RequestBody @Valid Outpost outpost) {

		if (outpost.getId() == null) {


			outpostService.addOutpost(outpost);
		} else   {

			outpostService.updateOutpost(outpost);
		}

		//outpostService.addOutpost(outpost);
		return outpost;

	}
	
	
}
