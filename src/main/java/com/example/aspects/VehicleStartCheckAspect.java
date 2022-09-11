package com.example.aspects;

//import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class VehicleStartCheckAspect {
	
	//private Logger logger = Logger.getLogger(VehicleStartCheckAspect.class.getName());
	
	@Before("execution(* com.example.services.*.*(..)) && args(vehicleStarted,..)")
	
	public void checkVehicleStarted(JoinPoint jointPoint, boolean vehicleStarted) throws Throwable{
		
		if(!vehicleStarted) {
			System.out.println("Error message");
			throw new RuntimeException("vehicle not started");
		
		}
	}

}
