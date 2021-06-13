package com.skillup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.skillup.model.Account;
import com.skillup.service.AccountService;
import com.skillup.util.AccountIDNotFoundException;

//@RestController

@Controller // Spring Bean - Managed IoC Container

//Back Controller//Who will call to theis BackController is DS
@RequestMapping("/skillup")
public class SkillupController {

	@Autowired
	AccountService accountService;

	// doGet(HttpServletRequest req, HttpServletResponse res) Method
	// @RequestMapping(value = "/welcome",method = RequestMethod.GET) //Defaulted
	// Get Request
	// @ResponseBody
	@GetMapping("/welcome")
	public String welcome() {
		// Business Logic
		// return "/WEB-INF/views/skilluphome.jsp"; //returning the JSP page information
		return "skilluphome";
	}

	@GetMapping("/viewaddform")
	public ModelAndView viewAddForm() {
		Account account = new Account();
		// account.setAccountId(121);
		ModelAndView mv = new ModelAndView("addaccount", "acc", account);
		return mv;
	}

	@PostMapping("/addaccount")
	public String addAccount(@ModelAttribute("acc") Account account) {
		// request.getParameter("accountId");
		System.out.println(account);

		boolean result = accountService.addAccount(account);
		if (result)
			return "success";
		else
			return "error";
	}

	@GetMapping("/searchaccount")
	public String searchAccountForm() {
		return "searchaccount";
	}

	@PostMapping("/search")
	public ModelAndView searchAccount(@RequestParam("accid") int accountId) throws AccountIDNotFoundException {

		// Account account = new Account(accountId,"Sabari",234.45f);
		Account account = accountService.findByAccountId(accountId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchaccount");
		mv.addObject("acc", account);

		return mv;
	}

	@ExceptionHandler(AccountIDNotFoundException.class)
	public ModelAndView handleException(AccountIDNotFoundException ex) {
		System.out.println("Inside Controller Level Exception!");
		String msg = ex.getMessage();
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("error");
		mv.setViewName("searchaccount");
		System.out.println(ex.getMessage());
		mv.addObject("err", msg);
		return mv;
	}

}
