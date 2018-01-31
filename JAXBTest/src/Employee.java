import java.time.LocalDateTime;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType (propOrder = {"name", "surname", "hiredate"})
@XmlRootElement (name = "Country")
public class Employee {
	private String name;
	private String surname;
	private LocalDateTime hiredate;
	Employee() {
		
	}
	Employee(String name, String surname, LocalDateTime hiredate) {
		this.setName(name);
		this.setSurname(surname);
		this.setHiredate(hiredate);
	}
	public String getName() {
		return name;
	}
	@XmlElement (name = "name")
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	@XmlElement (name = "surname")
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDateTime getHiredate() {
		return hiredate;
	}
	@XmlElement (name = "hiredate")
	@XmlJavaTypeAdapter (DateAdapter.class)
	public void setHiredate(LocalDateTime hiredate) {
		this.hiredate = hiredate;
	}
	
}
