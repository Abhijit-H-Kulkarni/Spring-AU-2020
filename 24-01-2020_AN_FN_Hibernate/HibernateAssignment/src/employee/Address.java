package employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int AddrId;
	String HNo, Street;

	public String getHNo() {
		return HNo;
	}

	public void setHNo(String hNo) {
		HNo = hNo;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}
	
}
