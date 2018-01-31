import java.time.LocalDateTime;

public class test {
	public static void main(String[] args) {
	Employee person0 = new Employee("Ivan", "Ivanov", LocalDateTime.parse("2017-01-01T10:00"));
	Employee person1 = new Employee("Ivan", "Petrov", LocalDateTime.parse("2017-01-01T12:00"));
	EmployeesList people = new EmployeesList();
	people.add(person1);
	people.add(person0);
	JAXBWorker.objectToXML(people);
	}
}