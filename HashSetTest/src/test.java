import java.util.HashSet;
public class test {

	public static void main(String[] args) {
		Employee e0 = new Employee("A");
		Employee e1 = new Employee("B");
		Employee e2 = new Employee("A");
		HashSet<Employee> hs = new HashSet<Employee>();
		hs.add(e0);
		hs.add(e1);
		hs.add(e2);
		for (Employee e : hs) {
			System.out.println(e.getName());
		}
		
	}

}
