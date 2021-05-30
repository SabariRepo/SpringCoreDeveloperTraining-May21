package com.messagingsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.messagingsystem.client.ClientMessagingSystem;
import com.messagingsystem.service.MailService;
import com.messagingsystem.service.SMSService;
import com.messagingsystem.service.TwitterService;

@Configuration
//@Lazy(value = true) //@PostConstruct and @PreDestroy Life-cycle Methods & Removing all manual configuration and replace them with annotations
//Property File handling -> PropertySources
//@Profile("prod")
public class MessagingSystemConfig { //XML File

	
	@Bean(name="sms")
	//@Profile("prod")
	public SMSService smsService() {
		SMSService smsService = new SMSService();
		return smsService;
	}
	
	@Bean(name="twitter")
	//@Profile("dev")
	public TwitterService twitterService() {
		TwitterService twitterService = new TwitterService();
		return twitterService;
	}
	
	@Bean(name="mail")
	//@Profile("qa")
	public MailService mailService() {
		MailService mailService = new MailService();
		return mailService;
	}
	
	
	//configuration code given to IoC container inorder to creat the instance and keep it in the object pool
	//Spring Bean Scopes
	//Singleton Bean (Default) - Only One Object will be created by the container
	//Prototype Bean - Explicitly mention if you want the object creation type should be of Prototype
	//Request - Web Application - WebMVC
	//Session - Web Application - WebMVC
	@Bean(name = "cms") //<bean id="cms" class="">
	//@Scope("prototype")
	@Lazy(value = true) //- Eager Beans & Lazy Bean
	//@Profile() //Profiling Concept
	public ClientMessagingSystem clientMessagingSystem() {
		ClientMessagingSystem clientMessagingSystem = new ClientMessagingSystem(); //Manual Wiring Constructor Based Injection
		//clientMessagingSystem.setiMessageService(twitterService());//Manual Wiring - Setter Based Wiring
		return clientMessagingSystem;
	}
}
