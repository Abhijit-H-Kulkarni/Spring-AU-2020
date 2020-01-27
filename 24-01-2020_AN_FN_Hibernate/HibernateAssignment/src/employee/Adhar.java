package employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Adhar {
@Id
String AdharNumber;
String Validity;
public String getAdharNumber() {
	return AdharNumber;
}
public void setAdharNumber(String Number) {
	AdharNumber = Number;
}
public String getValidity() {
	return Validity;
}
public void setValidity(String validity) {
	Validity = validity;
}

}
