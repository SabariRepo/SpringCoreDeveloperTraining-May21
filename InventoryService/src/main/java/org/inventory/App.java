package org.inventory;

import org.inventory.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    
    	ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    
    	ApplicationContext context1 = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
    	
    	System.out.println("Configuration File Is Detected!");
    	
    	ProductService productService1= (ProductService)context.getBean("product1");
    	
    	ProductService productService2= (ProductService)context.getBean("product2");
    	
    	//ProductService productService = context.getBean(ProductService.class);
    	
    	productService1.orderProduct();
    	productService2.orderProduct();
    	//NoUniqueBeanDefinitionException
    	//CannotLoadBeanClassException
    	//BeanDefintionStoreException
    	
    	//Manual Injection
       // ProductService productService = new ProductService();
        
        //productService.orderProduct();
    }
}
