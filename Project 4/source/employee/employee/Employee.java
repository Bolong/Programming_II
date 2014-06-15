package employee;
/**
A Employee with name and salary.
*/
class Employee {
	
	private String name;
	private int salary;
	
	/**
	Constructs a Employee with name and salary.
	@param name the name of Person
	@param salary the salary of employee	
	*/	
	Employee(String name,int salary) {
		this.name = name;
		this.salary = salary;
	}

	/**
	Sets the salary for the employee.
	@param salary the salary of employee
	*/		
	void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	Sets the name for the employee.
	@param name the name
	*/	
	void setName(String name) {
		this.name = name;
	}

	/**
	Get the name for the employee.
	*/	
	int getSalary() {
		return salary;
	}

	/**
	Get the name for the employee.
	*/	
	String getName() {
		return name;
	}

	/**
	prints out the employee.
	*/		
	public String toString() {
		return ("Name: " + name + ", Salary: " + salary);
	}

}
