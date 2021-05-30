package com.messagingsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.messagingsystem.client.ClientMessagingSystem;
import com.messagingsystem.service.EmployeeService;
import com.messagingsystem.service.SMSService;

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
        
    	//System.out.println("IoC Factory is initializd!.");
    	
   // EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
    	
    	//System.out.println("End........");
    	
    	ClientMessagingSystem clientMessagingSystem = (ClientMessagingSystem)applicationContext.getBean("cms");
    	System.out.println(applicationContext.containsBean("cms"));
    	ClientMessagingSystem clientMessagingSystem1 = applicationContext.getBean(ClientMessagingSystem.class);
    	
    	ClientMessagingSystem clientMessagingSystem2 = applicationContext.getBean(ClientMessagingSystem.class);
    	
    	System.out.println(clientMessagingSystem1==clientMessagingSystem2);
    	
    	
    	clientMessagingSystem1.clientMessageProcessing("Hi John Vijay, lets catchup this weekend!");
    
    	//applicationContext.close(); //Close this application context, destroying all beans in its bean factory. doClose()
    	
    	applicationContext.registerShutdownHook();
    	//applicationContext.getBean(SMSService.class);
    	//Register a shutdown hook named SpringContextShutdownHook with the JVM runtime, closing this context on JVM shutdown . doClose()
    }
}
