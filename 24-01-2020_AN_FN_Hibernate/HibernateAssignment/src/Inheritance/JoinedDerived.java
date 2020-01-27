package Inheritance;

import javax.persistence.Entity;

@Entity
public class JoinedDerived extends JoinedBase {
String section;

public String getSection() {
	return section;
}

public void setSection(String section) {
	this.section = section;
}

}
