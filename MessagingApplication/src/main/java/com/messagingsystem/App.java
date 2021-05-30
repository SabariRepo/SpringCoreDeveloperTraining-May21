package com.messagingsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.messagingsystem.client.ClientMessagingSystem;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//One way to pass on the configuration class 
    	//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MessagingSystemConfig.class);
    	
    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    	
    	
    	applicationContext.getEnvironment().setActiveProfiles("prod");
    	
    	//Second Way to load your configuration classes
    	applicationContext.register(MessagingSystemConfig.class,DataBasesConfiguration.class);
    	
    	applicationContext.refresh();
        
    //	ClientMessagingSystem clientMessagingSystem = (ClientMessagingSystem)applicationContext.getBean("cms");
    	
    	ClientMessagingSystem clientMessagingSystem1 = applicationContext.getBean(ClientMessagingSystem.class);
    	
    	ClientMessagingSystem clientMessagingSystem2 = applicationContext.getBean(ClientMessagingSystem.class);
    	
    	System.out.println(clientMessagingSystem1==clientMessagingSystem2);
    	
    	
    	clientMessagingSystem1.clientMessageProcessing("Hi John Vijay, lets catchup this weekend!");
    	
    }
}
