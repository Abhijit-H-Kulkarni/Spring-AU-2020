package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.EmployeeService;

public class MainClass {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeService emp = context.getBean(EmployeeService.class);
		emp.createEmp();
		emp.getEmp();
	}

}
