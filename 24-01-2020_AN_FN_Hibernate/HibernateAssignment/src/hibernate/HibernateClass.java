package hibernate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import employee.Address;
import employee.Adhar;
import employee.Employee;
import employee.Phone;

public class HibernateClass {
	static Scanner input = new Scanner(System.in);
	public static Employee getDetails(Session session) {
		String Name, Email, PhoneNumber, Hno, Street;
		int Age;
		Phone phone = new Phone();
		List<String> Vehicles = new ArrayList<String>();
		List<Address> Address = new ArrayList<Address>();
		String vehicles;
		System.out.println("Enter Name : ");
		Name = input.next();
		System.out.println("Enter Email : ");
		Email = input.next();
		System.out.println("Enter Age : ");
		Age = input.nextInt();
		System.out.println("Enter Phone Number : ");
		PhoneNumber = input.next();
		phone.setNumber(PhoneNumber);
		System.out.println("Enter the Address details or -1 to exit : ");
		int i = 1;
		while(true) {
			System.out.println("Address "+i+" :");
			System.out.println("Enter House Number : ");
			Hno = input.next();
			if(Hno.equals("-1"))
				break;
			System.out.println("Enter the Street details : ");
			Street = input.next();
			Address addr = new Address();
			addr.setHNo(Hno);
			addr.setStreet(Street);
			Address.add(addr);
			session.save(addr);
			i++;
		}
		System.out.println("Enter the names of vehicles you own or -1 to exit : ");
		i = 1;
		while(true) {
			System.out.println("Vehicle "+i+" :");
			vehicles = input.next();
			if(vehicles.equals("-1"))
				break;
			Vehicles.add(vehicles);
			i++;
		}
		Employee employee =  new Employee();
		employee.setName(Name);
		employee.setAge(Age);
		employee.setEmail(Email);
		employee.setPhoneNumber(phone);
		employee.setVehicles(Vehicles);
		employee.setAddress(Address);
		return employee;
	}
	
	public static Adhar setAdhar() {
		String Number, Validity;
		System.out.println("Enter your Adhar number and Validity(MM/YY) :");
		Number = input.next();
		Validity = input.next();
		Adhar adhar = new Adhar();
		adhar.setAdharNumber(Number);
		adhar.setValidity(Validity);
		return adhar;
	}
	
	public static void main(String[] args) {
		
	int ch;
	SessionFactory sf = new Configuration().configure().buildSessionFactory();;
	Session session;
	
	while(true) {
		System.out.println("Choose any of the below CRUD operations :\n1.Insert\n2.Retrieve whole Employee table\n3.Retrieve a single document\n4.Update\n5.Delete\n6.Update name using native query\n7.Retrieve names with same age using named query\n8.Exit");
		ch = input.nextInt();
		switch(ch) {
		// Create.
		case 1:
			session=sf.openSession();
			session.beginTransaction();
			Employee employee = getDetails(session);
			Adhar adhar = setAdhar();
			session.save(adhar);
			employee.setAdharDetails(adhar);
			session.save(employee);
			session.getTransaction().commit();
			System.out.println("Inserted Succesfully.");
			session.close();
		break;
		// Retrieve
		case 2:
			session=sf.openSession();
			session.beginTransaction();
			Query qry = session.createQuery("FROM Employee");
			Iterator Result = qry.getResultList().iterator();
			while(Result.hasNext()) {
				Employee tuple = (Employee) Result.next();
				System.out.println("ID : "+tuple.getID()+" "+"Name : "+tuple.getName()+" "+"Age : "+tuple.getAge()+" "+"Email : "+tuple.getEmail()+" "+"Phone Number : "+tuple.getPhoneNumber().getNumber()+" Adhar Number : "+tuple.getAdharDetails().getAdharNumber());
			}
			session.close();
		break;
		// Retrieve a single doc.
		case 3:
			session=sf.openSession();
			session.beginTransaction();
			System.out.println("Enter the id to retrieve :");
			int ID = input.nextInt();
			try {
			employee = session.get(Employee.class , ID);
			System.out.println("ID : "+employee.getID()+" Name : "+employee.getName()+" Age : "+employee.getAge()+" Email : "+employee.getEmail()+" Phone Number : "+employee.getPhoneNumber().getNumber());
			int i = 1;
			for(Address addr : employee.getAddress()) {
				System.out.print("Address "+i+" : #"+addr.getHNo()+", "+addr.getStreet()+"\t");
				i++;
			}
			i = 1;
			for(String vehicle : employee.getVehicles()) {
				System.out.print("Vehicle "+i+" : "+vehicle+"\t");
				i++;
			}
			System.out.println("Adhar Details :\nAdhar Number "+employee.getAdharDetails().getAdharNumber()+"\nAdhar Validity : "+employee.getAdharDetails().getValidity());
			}catch(Exception e) {
				System.out.println("The ID Does not exists.");
			}
			session.close();
		break;
		// Update.
		case 4:
			session=sf.openSession();
			session.beginTransaction();
			Employee employeeUpdate = getDetails(session);
			session.saveOrUpdate(employeeUpdate);
			session.getTransaction().commit();
			System.out.println("Updated successfully.");
			session.close();
		break;
		// Delete.
		case 5:
			System.out.println("Enter the details of record to remove : ");
			session=sf.openSession();
			session.beginTransaction();
			Employee employeeDel = getDetails(session);
			session.delete(employeeDel);
			session.getTransaction().commit();
			System.out.println("Removed Successfully.");
			session.close();
		break;
		// Native Query.
		case 6:
			System.out.println("Enter the id to update :");
			ID = input.nextInt();
			System.out.println("Enter the updated name :");
			String name = input.next();
			session=sf.openSession();
			session.beginTransaction();
			qry = session.createNativeQuery("Update employee set name=:name where id=:id");
			qry.setParameter("name", name);
			qry.setParameter("id", ID);
			qry.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Updated sucessfully");
			session.close();
		break;
		// Named Query.
		case 7:
			session=sf.openSession();
			session.beginTransaction();
			System.out.println("Enter the age to retrieve :");
			int age = input.nextInt();
			TypedQuery query = session.getNamedQuery("findEmployeeById"); 
			query.setParameter("age", age);
			Iterator result = query.getResultList().iterator();
			while(result.hasNext()) {
				Employee emp = (Employee)result.next();
				System.out.println("Name : "+emp.getName());
			}
			session.close();
		break;
		default: 
			System.exit(0);
		}
	}
	}																									
}
