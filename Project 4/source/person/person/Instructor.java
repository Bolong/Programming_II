package person;
//Instructor is a subclass class of Person
class Instructor extends Person {

	private int salary = 0;

	/**
	Constructs a Instructor with name and year of birth.
	@param name the name of Instructor
	@param birth the birth year of Instructor	
	*/		
	Instructor(String name, int birth) {
		super(name, birth);
	}

	/**
	Sets the salary.
	@param salary the salary
	*/		
	void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	Get the salary.
	*/		
	Integer getSalary() {
		return salary;
	}

	/**
	prints out the Instructor.
	*/		
	public String toString() {
		return (super.toString() + "\n  " + "Salary: " + salary);
	}

}
