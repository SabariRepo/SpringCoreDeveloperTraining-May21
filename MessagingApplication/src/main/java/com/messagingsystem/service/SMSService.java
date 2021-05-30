package com.messagingsystem.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component(value = "sms") //@Service , @Repository , @Configuration
//@Scope(value = "prototype")
//@Profile("dev")
@Lazy
public class SMSService implements IMessageService {

	public int defaultNoOfMessage=0;
	
	@Value("${messagetype}")
	String data;
	
	public void send(String message) {
		
		System.out.println("SMS Message: "+message + data);
		
	}
	//Connection con ;
	//post constructing the object this life-cycle method will get invoked
	@PostConstruct
	public void init() {
		System.out.println("SMSService instance is created");
		this.defaultNoOfMessage=10;
	}
	
	//Before destroying the spring bean object, this life-cycle method will get invoked
	@PreDestroy
	public void destroy() {
		System.out.println("SMSService Object is going to be destroyed");
		//con.close()
	}
	
	
}
