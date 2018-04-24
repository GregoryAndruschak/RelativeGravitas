package ua.kma.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
//		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
//
//		DataBaseWorker us = (DataBaseWorker) context.getBean("worker");
//
//		us.test();
	}
}
