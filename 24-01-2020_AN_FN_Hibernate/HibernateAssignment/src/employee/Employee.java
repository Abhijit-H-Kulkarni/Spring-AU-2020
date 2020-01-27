package employee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@NamedQuery(  
        name = "findEmployeeById",  
        query = "from Employee where age = :age"  
        )  
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
	String Name;
	int Age;
	String Email;
	@OneToOne
	Adhar AdharDetails;
	
	// Similarly ManyToOne can be done.
	@OneToMany
	@JoinTable(
	        name="CUST_ADDRESS",
	        joinColumns=
	                @JoinColumn(name="ID"),
	        inverseJoinColumns=
	        		@JoinColumn(name="Addr_ID"))
	private List<Address> address = new ArrayList<Address>();
	
	@Embedded
	Phone PhoneNumber;
	@ElementCollection
	@GenericGenerator(name="sequence_gen",strategy="sequence")
	@CollectionId(columns = @Column(name="Vehicle_Name"),generator="sequence_gen",type=@Type(type="long"))
	List<String> Vehicles;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setPhoneNumber(Phone phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Phone getPhoneNumber() {
		return PhoneNumber;
	}
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public void setVehicles(List<String> vehicles) {
		Vehicles = vehicles;
	}
	public List<String> getVehicles() {
		return Vehicles;
	}
	public void setAdharDetails(Adhar adharDetails) {
		AdharDetails = adharDetails;
	}
	public Adhar getAdharDetails() {
		return AdharDetails;
	}
	
}
