package models;
import java.util.*;
import java.util.Map.Entry;

public class EmployeeList {
	public Map<Integer, Employee> EmpNames;
	public EmployeeList() {
		
	}
	
	public EmployeeList(Map<Integer, Employee> empNames){
		this.EmpNames = empNames;
	}
	
	public void getEmployees() {
		for(Entry<Integer, Employee> emp: this.EmpNames.entrySet()) {
			System.out.print("ID : "+emp.getKey()+" Name : ");
			emp.getValue().getDetails();
		}
	}
}
