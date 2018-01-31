import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "employees")
public class EmployeesList {
	ArrayList<Employee> employees;
	EmployeesList() {
		this.employees = new ArrayList<Employee>();
	}
	@XmlElement (name = "employee")
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void add(Employee person) {
		employees.add(person);
	}
}
