package com.skillup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.skillup"})
@EnableWebMvc
//Adding this annotation to an @Configuration class imports the Spring MVC configuration from WebMvcConfigurationSupport
//To customize the imported configuration, implement the interface WebMvcConfigurer and override individual methods
public class SkillUpConfiguration{ //implements WebMvcConfigurer {
	
	//WebMvcConfigurerAdapter
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		//Setter based Injection 
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}

	
}
