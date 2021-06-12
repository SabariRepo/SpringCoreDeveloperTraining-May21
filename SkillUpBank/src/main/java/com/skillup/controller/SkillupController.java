package com.skillup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController

@Controller //Spring Bean - Managed IoC Container

//Back Controller//Who will call to theis BackController is DS
@RequestMapping("/skillup")
public class SkillupController {
	
	//doGet(HttpServletRequest req, HttpServletResponse res) Method
	//@RequestMapping(value = "/welcome",method = RequestMethod.GET) //Defaulted Get Request
	//@ResponseBody
	@GetMapping("/welcome")
	public String welcome() {
		//Business Logic
		//return "/WEB-INF/views/skilluphome.jsp"; //returning the JSP page information
		return "skilluphome";
	}
}
