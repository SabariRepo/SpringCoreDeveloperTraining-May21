package com.messagingsystem.service;

import org.springframework.stereotype.Component;

@Component(value = "twitter")
public class TwitterService implements IMessageService {

	public void send(String message) {
		System.out.println("Tweet Message: "+message);
		
	}
}
