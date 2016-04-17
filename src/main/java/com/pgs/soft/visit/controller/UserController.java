/*package com.pgs.soft.visit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.pgs.soft.visit.domain.User;
import com.pgs.soft.visit.service.UserService;

@RestController
@RequestMapping(value = "/rejestracja")
public class UserController {

	@Autowired 
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(@RequestBody  User user) {

	userService.addUser(user);
	
	}
	
	
}*/

