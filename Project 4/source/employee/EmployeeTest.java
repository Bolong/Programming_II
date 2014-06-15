package employee;
/**
 This program tests the Employee class and
 its subclasses.
 */
 public class EmployeeTest {
  public static void main(String[] args) {
	Employee employee = new Employee("Mary",5000);	  
    Manager manager = new Manager("Jack",6000);
    manager.setDepartment("market");
    Executive executive = new Executive("John",8000);
    executive.setDepartment("Executive"); 
    System.out.println(employee.toString());    
    System.out.println(manager.toString());    
    System.out.println(executive.toString());
  }
}
