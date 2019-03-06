package com.siddu.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("msg", "This admin page");
		return "adminPage";
	}

}
