import java.util.ArrayList;
import java.util.List;




/**
 * A School class .
 */
public class School  {
	
	public List<Course> courselist; 
	public List<Student> studentlist;
	public List selectlist; 
	
	/**
	 * Constructs an empty school.
	 */	
	public School() {
		this.courselist = new ArrayList(); 
		this.studentlist = new ArrayList();		
		this.selectlist = new ArrayList(); 
	}  
	
	/**
	 *  Add a class.
	 * 
	 * @param course
	 *            the Course inputed
	 */
	public void addClass(Course course) {
	
			courselist.add(course);	

	}	
	
	/**
	 *  Remove a class.
	 * 
	 * @param name
	 *            the Course name
	 */
	public void removeClass(String name) {
		for(int i = courselist.size()-1; i >=0; i--){
			if(courselist.get(i).getName().equals(name)){
				courselist.remove(i);
			}
		}

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
	 *  Add a student and class.
	 * 
	 * @param select
	 *            select = coursename+","+studentname
	 */
	public void addSelect(String select) {
		selectlist.add(select);	

	}		
	
	/**
	 *  Drop a student from a class.
	 * 
	 * @param select
	 *            select = course name+","+student name
	 */
	public void dropSelect(String select) {
		for(int i = selectlist.size()-1; i >=0; i--){
			if(selectlist.get(i).equals(select)){
				selectlist.remove(i);
			}
		}

	}
	
	

	/**
	 *  Return a list of course name.
	 * 
	 * @return list of course name.
	 */	
	public List getCourseNamelist() {
		List mylist = new ArrayList();
		for(int i=0;i<courselist.size();i++){
			mylist.add(courselist.get(i).getName());
		}
		return mylist;
	}
	
	/**
	 *  Return a list of student name.
	 * 
	 * @return list of student name.
	 */	
	public List getStudentNamelist() {
		List mylist = new ArrayList();
		for(int i=0;i<studentlist.size();i++){
			mylist.add(studentlist.get(i).getName());
		}
		return mylist;
	}
	
	/**
	 *  Return student's course.
	 * 
	 * @param name
	 *            student's name
	 *            
	 * @return list of student's course.
	 */	
	public List getSClist(String name) {
		List mylist = new ArrayList();
		for(int i=0;i<selectlist.size();i++){
			String[] select = selectlist.get(i).toString().split(",");
			if(name.equals(select[1])){
			mylist.add(select[0]);
			}
		}
		return mylist;
	}
	
	/**
	 *  Return students in a course.
	 * 
	 * @param name
	 *            course's name
	 *            
	 * @return list of students in a course.
	 */	
	public List getCSlist(String name) {
		List mylist = new ArrayList();
		for(int i=0;i<selectlist.size();i++){
			String[] select = selectlist.get(i).toString().split(",");
			if(name.equals(select[0])){
			mylist.add(select[1]);
			}
		}
		return mylist;
	}
	
	public List<Course> getCourselist() {
		return courselist;
	}

	

	public List<Student> getStudentlist() {
		return studentlist;
	}


	public List getSelectlist() {
		return selectlist;
	}

}