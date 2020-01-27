package employee;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {
	String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
