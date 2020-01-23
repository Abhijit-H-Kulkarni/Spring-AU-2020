package models;

public class Employee {
	String empName;
	
	public Employee(String empName) {
		this.empName = empName;
	}
	
	public void getDetails() {
		System.out.println(this.empName);
	}
}
