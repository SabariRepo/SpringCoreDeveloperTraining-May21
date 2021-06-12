package com.skillup;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//This class is meant for activating the DispatcherServlet
//No Annotations are required
//Step 1: implementing the WebApplicationInitializer interface
public class WebServletConfiguration implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//Step2: Create the IoC Context - ApplicationContext
		//AnnotationConfigApplicationContext
		//XmlWebApplicationContext context = new XmlWebApplicationContext();
		AnnotationConfigWebApplicationContext webIoCContext = new AnnotationConfigWebApplicationContext();
		
		//Step 3: We need register the Java Configuration file.
		
		webIoCContext.register(SkillUpConfiguration.class);
		
		//Step 4: We need to activate the Dispatcher Servlet and bind the ApplicationContext with ServletContext
		//Register The Servlet - Binded with ApplicationContext
		
		ServletRegistration.Dynamic servletRegistration = 
				servletContext.addServlet("dispatcher", new DispatcherServlet(webIoCContext));
		//Step 5: Starting the servlet and registring them into the WebContainer at the 
		//time of deploying the application into the server(EAP)
		
		servletRegistration.setLoadOnStartup(1);
		
		//Step 6: Set the URL-Pattern-mapping
		servletRegistration.addMapping("/");
	}
}
