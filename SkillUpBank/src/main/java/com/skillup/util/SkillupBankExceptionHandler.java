package com.skillup.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SkillupBankExceptionHandler {
	
	@ExceptionHandler(AccountIDNotFoundException.class)
	public ModelAndView handleException(AccountIDNotFoundException ex) {
		System.out.println("Inside The Controller Advice!!");
		String msg = ex.getMessage();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchaccount");
		System.out.println(ex.getMessage());
		mv.addObject("error", msg);
		return mv;
	}
	
	
}
