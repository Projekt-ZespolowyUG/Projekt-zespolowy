package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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



	/*@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addOutpost(@ModelAttribute @Valid Outpost outpost, BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("outpost");
			List<Outpost> outposts = outpostService.getOutposts();
			modelAndView.addObject("outposts", outposts);
			return modelAndView;
		}

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

}