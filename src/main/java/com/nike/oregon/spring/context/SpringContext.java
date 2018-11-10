package com.nike.oregon.spring.context;

import com.nike.oregon.spring.service.FlightService;
import com.nike.oregon.spring.service.FlightServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
    static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:context.xml");
    }


   /* public static void main(String[] args) {
        SpringContext springContext =  new SpringContext();
        FlightService flightService = applicationContext.getBean(FlightService.class);
        flightService.invoke();

    }*/


}
