package com.messagingsystem.service;

import org.springframework.stereotype.Component;

@Component(value = "mail")
public class MailService implements IMessageService{

	public void send(String message) {
		System.out.println("E-Mail Message: "+message);
		
	}
}
