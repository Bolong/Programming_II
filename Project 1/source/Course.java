
/**
 * A Course class contains name, course number, and instructor.
 */
public class Course   {
	
	private String name; 
	private String number;
	private String instructor;

	
	public Course(String name, String number, String instructor) {
		this.name = name;
		this.number = number;
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
	
	
}