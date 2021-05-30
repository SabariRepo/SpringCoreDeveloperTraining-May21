package com.messagingsystem.client;

import org.springframework.beans.factory.annotation.Autowired;

import com.messagingsystem.service.IMessageService;
import com.messagingsystem.service.SMSService;
import com.messagingsystem.service.TwitterService;

public class ClientMessagingSystem {

	@Autowired //Field Level Autowiring
	private IMessageService iMessageService;//new SMSService();
	
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
		
		iMessageService.send(message);
	}
}
