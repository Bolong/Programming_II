import java.io.Serializable;


/**
 * A Student class contains name, student number, major and QPA.
 */
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L; 	
	private String  name; 
	private String  number;
	private String  major;
	private double  qpa;	
	
	public Student(String name, String number, String major,double qpa) {
		this.name = name;
		this.number = number;
		this.major = major;
		this.qpa = qpa;
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

	public double getQpa() {
		return qpa;
	}

	public void setQpa(double qpa) {
		this.qpa = qpa;
	}

	
	
	
}