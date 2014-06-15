package employee;
//Manager is a subclass class of Employee
class Manager extends Employee {

	private String department = "Unknown";

	/**
	Constructs a Manager with name and salary.
	@param name the name of Manager
	@param salary the salary of Manager	
	*/		
	Manager(String name, int salary) {
		super(name, salary);
	}

	/**
	Sets the department.
	@param department the department
	*/		
	void setDepartment(String department) {
		this.department = department;
	}

	/**
	Get the department.
	*/		
	String getDepartment() {
		return department;
	}

	/**
	prints out the Manager.
	*/		
	public String toString() {
		return (super.toString() + "\n  " + "Department: " + department);
	}

}
