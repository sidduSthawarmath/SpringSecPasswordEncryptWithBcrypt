package com.siddu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class HomeController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("msg", "This home page");
		return "homePage";
	}

	@ResponseBody
	@RequestMapping(value = "passEncode", method = RequestMethod.GET)
	public String adminPage(@RequestParam("password") String password) {
		return passwordEncoder.encode(password);
	}

}
