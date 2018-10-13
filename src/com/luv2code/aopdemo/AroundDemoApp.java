package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = fortuneService.getFortune();
		
		myLogger.info("My fortune is: " + data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
	}

}
