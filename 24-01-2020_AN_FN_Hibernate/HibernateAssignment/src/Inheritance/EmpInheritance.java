package Inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmpInheritance extends Person {
String company;
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
}
