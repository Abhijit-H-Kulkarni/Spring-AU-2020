package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import models.EmployeeList;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeList emp = (EmployeeList) context.getBean("Emp");
		emp.getEmployees();

	}

}
