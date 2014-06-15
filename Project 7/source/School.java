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

	/**
	 *  get list of student.
	 * 
	 */
	public String listStudent() {
		String str = "";
		if(studentlist.size()>0){
		for(int i=0;i<studentlist.size();i++){
			str = str + "Name:"+studentlist.get(i).getName()+", Number:"+studentlist.get(i).getNumber()+", Major:"+studentlist.get(i).getMajor()+", QPA:"+studentlist.get(i).getQpa()+"\n";
		}}	
		return str;
	}
	
	/**
	 *  retrieve student by number.
	 * 
	 */
	public Student retrieveStudent(String num) {
		if(studentlist.size()>0){
		for(int i=0;i<studentlist.size();i++){
			if(studentlist.get(i).getNumber().equals(num)){
				return studentlist.get(i);	
			}
		}}	
		return null;
	}
	
	/**
	 *  update student.
	 * 
	 */
	public void updateStudent(Student std) {
		if(studentlist.size()>0){
		for(int i=0;i<studentlist.size();i++){
			if(studentlist.get(i).getNumber().equals(std.getNumber())){
				studentlist.get(i).setMajor(std.getMajor());	
				studentlist.get(i).setName(std.getName());
				studentlist.get(i).setQpa(std.getQpa());				
			}
		}}	
	}
	
	/**
	 *  delete student.
	 * 
	 */
	public void deleteStudent(String num) {
		if(studentlist.size()>0){
		for(int i=0;i<studentlist.size();i++){
			if(studentlist.get(i).getNumber().equals(num)){
				studentlist.remove(i);				
			}
		}}	
	}
	
	/**
	 *  judge if number is already exist.
	 * 
	 */
	public boolean isExist(String num) {
		if(studentlist.size()>0){
		for(int i=0;i<studentlist.size();i++){
			if(studentlist.get(i).getNumber().equals(num)){
				return true;				
			}
		}}
		return false;	
	}
	
	public List<Student> getStudentlist() {
		return studentlist;
	}


}