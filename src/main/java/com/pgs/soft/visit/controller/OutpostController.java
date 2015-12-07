package com.pgs.soft.visit.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pgs.soft.visit.domain.Outpost;
import com.pgs.soft.visit.service.OutpostService;

@Controller
@RequestMapping(value="/outpost")
public class OutpostController {

	
	  @Autowired
	    private OutpostService outpostService;
	  
	  
	    @RequestMapping(value="/addOutpost", method=RequestMethod.GET)
	    public ModelAndView addOutpostPage() {
	        ModelAndView modelAndView = new ModelAndView("outpost");
	        modelAndView.addObject("outpost", new Outpost());
	        return modelAndView;
	    }
	     
	    @RequestMapping(value="/add", method=RequestMethod.POST)
	    public ModelAndView addingOutpost(@ModelAttribute Outpost outpost) {
	         
	        ModelAndView modelAndView = new ModelAndView("index");
	        outpostService.addOutpost(outpost);
	         
	        String message = "Outpost was successfully added.";
	        modelAndView.addObject("message", message);
	         
	        return modelAndView;
	    }
	  
	  
	    @RequestMapping(value="/list")
	    public ModelAndView listOfOutposts() {
	        ModelAndView modelAndView = new ModelAndView("showAllOutpost");
	         
	        List<Outpost> outposts = outpostService.getOutposts();
	        modelAndView.addObject("outposts", outposts);
	         
	        return modelAndView;
	    }
	  
	  
	  
}