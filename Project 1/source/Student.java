
/**
 * A Student class contains name, student number, and major.
 */
public class Student   {
	
	private String  name; 
	private String  number;
	private String  major;
	
	public Student(String name, String number, String major) {
		this.name = name;
		this.number = number;
		this.major = major;
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	
	
	
}