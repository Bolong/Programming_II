package person;
/**
 A Person with name and year of birth.
 */
 public class Person {
	
	private String name;
	private int birth;
	
	/**
	Constructs a Person with name and year of birth.
	@param name the name of Person
	@param birth the birth year of person	
	*/
	public Person(String name,int birth) {
		this.name = name;
		this.birth = birth;
	}

	/**
	Sets the birth for the person.
	@param birth the birth year
	*/	
	void setBirth(int birth) {
		this.birth = birth;
	}

	/**
	Sets the name for the person.
	@param name the name
	*/	
	void setName(String name) {
		this.name = name;
	}

	/**
	Get the birth for the person.
	*/	
	int getBirth() {
		return birth;
	}

	/**
	Get the name for the person.
	*/	
	String getName() {
		return name;
	}

	/**
	prints out the person.
	*/	
	public String toString() {
		return ("Name: " + name + ", Year of Birth: " + birth);
	}

}
