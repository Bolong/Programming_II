package person;
//Student is a subclass class of Person
class Student extends Person {

	private String major = "Unknown";

	/**
	Constructs a Student with name and year of birth.
	@param name the name of Student
	@param birth the birth year of Student	
	*/	
	Student(String name, int birth) {
		super(name, birth);
	}

	/**
	Sets the major for the Student.
	@param major the major
	*/	
	void setMajor(String major) {
		this.major = major;
	}

	/**
	Get the major.
	*/		
	String getMajor() {
		return major;
	}

	/**
	prints out the Student.
	*/		
	public String toString() {
		return (super.toString() + "\n  " + "Major: " + major);
	}

}
