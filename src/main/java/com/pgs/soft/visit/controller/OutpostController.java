package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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

<<<<<<< HEAD


	/*@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addOutpost(@ModelAttribute @Valid Outpost outpost, BindingResult result) {
=======
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Outpost> listOutposts() {

		return outpostService.getOutposts();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addOutpost(@ModelAttribute @Valid Outpost outpost) {

		if (outpost.getIdOutpost() == null) {
>>>>>>> 735ba27ba731fba03dde87ced6c9a650f87be8d1

			outpostService.addOutpost(outpost);
		} else {

			outpostService.updateOutpost(outpost);
		}

<<<<<<< HEAD
		ModelAndView modelAndView = new ModelAndView("outpost");
		outpostService.addOutpost(outpost);

		return modelAndView;
	}*/
	
	@RequestMapping(value="/id", method=RequestMethod.POST)
    public Outpost getbyId(@PathVariable Integer id) {
        Outpost outpost = outpostService.getOutpost(id);
        return outpost;
    }
     
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public Outpost edditingOutpost(@ModelAttribute Outpost outpost, @PathVariable Integer id) {
         
         
        outpostService.updateOutpost(outpost);
         
        return outpost;
    }
=======
	}

	@RequestMapping(value = "/{id}")
	public Outpost getOutpost(@PathVariable("id") Long id) {

		return outpostService.getOutpost(id);
	}
>>>>>>> 735ba27ba731fba03dde87ced6c9a650f87be8d1

}