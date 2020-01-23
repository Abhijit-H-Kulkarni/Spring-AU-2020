package services;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import models.Employee;


@Component
public class EmployeeService {
	List<Employee> emps = new ArrayList<Employee>();
	
	public void createEmp() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String name;
		while(true) {
			System.out.println("Enter employee name or -1 to exit : ");
			name = input.next();
			if(name.equals("-1"))
				break;
			Employee emp = new Employee(name);
			this.emps.add(emp);
		}
	}
	
	public void getEmp() {
		for(Employee emp : this.emps)
			System.out.println("Name : "+emp.name);
	  }
}
