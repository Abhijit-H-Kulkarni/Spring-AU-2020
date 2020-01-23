package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.ExternalService;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		ExternalService service = (ExternalService) context.getBean(ExternalService.class);
		service.getDetails();
	}

}
