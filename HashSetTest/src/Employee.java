
public class Employee {
	private String name;
	Employee(String name) {
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Employee)) {
			return false;
		}
		Employee e = (Employee)o;
		return e.name.equals(name);
	}
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		return result;
	}
}
