package com.accolite.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

	// List to hold Employees object
	private List<Employee> empList = null;
	private Employee emp = null;
	private StringBuilder data = null;

	// getter method for employee list
	public List<Employee> getEmpList() {
		return empList;
	}
	boolean bfName = false;
	boolean blName = false;
	boolean bAge = false;
	boolean bGender = false;
	boolean blocation = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("Employee")) {
			// create a new Employee and put it in Map
			String id = attributes.getValue("id");
			// initialize Employee object and set id attribute
			emp = new Employee();
			emp.setId(Integer.parseInt(id));
			// initialize list
			if (empList == null)
				empList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("firstName")) {
			// set boolean values for fields, will be used in setting Employee variables
			bfName = true;
		} else if (qName.equalsIgnoreCase("lastName")) {
			// set boolean values for fields, will be used in setting Employee variables
			blName = true;
		} else if (qName.equalsIgnoreCase("age")) {
			bAge = true;
		} else if (qName.equalsIgnoreCase("gender")) {
			bGender = true;
		} else if (qName.equalsIgnoreCase("location")) {
			blocation = true;
		}
		// create the data container
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bAge) {
			emp.setAge(Integer.parseInt(data.toString()));
			bAge = false;
		} else if (bfName) {
			emp.setfirstName(data.toString());
			bfName = false;
		} else if (blName) {
			emp.setlastName(data.toString());
			blName = false;
		} else if (blocation) {
			emp.setLocation(data.toString());
			blocation = false;
		} else if (bGender) {
			emp.setGender(data.toString());
			bGender = false;
		}
		
		if (qName.equalsIgnoreCase("Employee")) {
			// add Employee object to list
			empList.add(emp);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}

