package com.messagingsystem.service;

public class SMSService implements IMessageService {

	public void send(String message) {
		
		System.out.println("SMS Message: "+message);
		
	}
}
