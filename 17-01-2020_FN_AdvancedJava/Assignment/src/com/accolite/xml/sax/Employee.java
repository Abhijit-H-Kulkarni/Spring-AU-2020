package com.accolite.xml.sax;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getlastName() {
		return lastName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee:: ID=" + this.id + " First Name=" + this.firstName +" Last Name=" + this.lastName + " Age=" + this.age + " Gender=" + this.gender
				+ " Location =" + this.location;
	}

}
