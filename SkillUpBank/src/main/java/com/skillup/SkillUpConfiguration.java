package com.skillup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import(value = { DBConfig.class })
@ComponentScan(basePackages = { "com.skillup" })
@EnableWebMvc
//Adding this annotation to an @Configuration class imports the Spring MVC configuration from WebMvcConfigurationSupport
//To customize the imported configuration, implement the interface WebMvcConfigurer and override individual methods
public class SkillUpConfiguration implements WebMvcConfigurer {

	// WebMvcConfigurerAdapter

	// Create a Content Negotiation Configuration Code

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true)
		.favorParameter(true)
		.parameterName("dataFormat")
		.ignoreAcceptHeader(false) //deactivate
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	//http://localhost:8080/SkillUpBank/skillup/accounts?dataFormat=xml

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		// Setter based Injection
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
