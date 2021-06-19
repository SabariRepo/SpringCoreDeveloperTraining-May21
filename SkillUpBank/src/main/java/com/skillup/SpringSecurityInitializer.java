package com.skillup;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	public SpringSecurityInitializer() {
		//1. Spring MVC Configuration Class
		//2. Spring Security Configuration class
		super(SkillUpConfiguration.class,LoginSecurityConfiguration.class);
	}
}
