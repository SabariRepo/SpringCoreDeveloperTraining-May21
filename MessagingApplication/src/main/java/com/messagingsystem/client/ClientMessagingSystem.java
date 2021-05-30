package com.messagingsystem.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.messagingsystem.service.IMessageService;
import com.messagingsystem.service.SMSService;
import com.messagingsystem.service.TwitterService;

//@Component
@Service(value = "cms")
public class ClientMessagingSystem {

	@Autowired //Field Level Autowiring
	@Qualifier("sms")
	private IMessageService iMessageService;//new SMSService();
	
	/*@Autowired
	private IMessageService sms;
	//private SMSService a1;
	
	@Autowired
	private IMessageService twitter;
	
	@Autowired
	private IMessageService mail;*/
	
	//@Autowired //Field Level Autowiring
	//private IMessageService twitter;
	
	//@Autowired //Field Level Autowiring
	//private IMessageService mail;
	
	public ClientMessagingSystem() {
		System.out.println("No-Arg Constructor");
	}
	
	//Constructor Based Injection
	/*@Autowired
	public ClientMessagingSystem(IMessageService iMessageService) {
		System.out.println("Constructor Based Injection");
		this.iMessageService = iMessageService;
		
	}*/
	
	//Setter Based Injection
/*	@Autowired
	public void setiMessageService(TwitterService iMessageService) {
		System.out.println("Setter Based Injection");
		this.iMessageService = iMessageService;
	}*/

	public void clientMessageProcessing(String message) {
		//System.out.println("The of Of Message"+ ((SMSService)iMessageService).defaultNoOfMessage);
		iMessageService.send(message);
	}
}
