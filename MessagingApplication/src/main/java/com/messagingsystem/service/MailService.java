package com.messagingsystem.service;

public class MailService implements IMessageService{

	public void send(String message) {
		System.out.println("E-Mail Message: "+message);
		
	}
}
