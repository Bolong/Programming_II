package person;
/**
 This program tests the Person class and
 its subclasses.
 */
class PersonTest {
  public static void main(String[] args) {
	Person person = new Person("Mike person",1991);
    Student student = new Student("Jane Programmer",1990);
    student.setMajor("computer");
    Instructor instructor = new Instructor("Tom Professor",1960);
    instructor.setSalary(8000);   
    System.out.println(person.toString());    
    System.out.println(student.toString());    
    System.out.println(instructor.toString());
  }
}
