package com.messagingsystem.service;

public class TwitterService implements IMessageService {

	public void send(String message) {
		System.out.println("Tweet Message: "+message);
		
	}
}
