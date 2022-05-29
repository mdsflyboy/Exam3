
public class Student {
	
	String name;
	char section;
	double marks;
	
	public Student(String name, char section, double marks) {
		this.name = name;
		this.section = section;
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		return (int) section;
	}

}
