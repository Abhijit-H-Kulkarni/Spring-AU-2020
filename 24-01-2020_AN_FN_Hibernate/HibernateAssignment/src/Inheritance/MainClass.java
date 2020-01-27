package Inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();;
		Session session;
		session=sf.openSession();
		session.beginTransaction();
		EmpInheritance emp = new EmpInheritance();
		emp.setName("Abhijit");
		emp.setCompany("Accolite");
		emp.setID(1);
		session.save(emp);
		Product p1 = new Product();
		session.save(p1);
		JoinedDerived derived = new JoinedDerived();
		session.save(derived);
		session.getTransaction().commit();
		session.close();
	}

}
