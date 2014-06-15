import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A School class .
 */
public class School implements Serializable{
	
	private static final long serialVersionUID = 1L; 	
	public List<Student> studentlist;
	
	/**
	 * Constructs an empty school.
	 */	
	public School() {
		this.studentlist = new ArrayList();		
	}  
	
	
	/**
	 *  Add a student.
	 * 
	 * @param student
	 *            the student inputed
	 */
	public void addStudent(Student student) {
		studentlist.add(student);	

	}
	
	/**
	 *  print out list of student.
	 * 
	 */
	public void printStudent() {
		if(studentlist.size()>0){
		for(int i=0;i<studentlist.size();i++){
			System.out.println("Name:"+studentlist.get(i).getName()+", Number:"+studentlist.get(i).getNumber()+", Major:"+studentlist.get(i).getMajor()+", QPA:"+studentlist.get(i).getQpa());
		}}else {
			System.out.println("there is no student in school");
		}	

	}	

	public List<Student> getStudentlist() {
		return studentlist;
	}


}