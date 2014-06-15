import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SchoolTester {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		School school = new School();
		school.addClass(new Course("maths", "1", "Tom"));
		school.addClass(new Course("computer", "2", "Tom"));
		school.addClass(new Course("music", "3", "Tom"));
		school.addClass(new Course("biology", "4", "Tom"));
		school.addClass(new Course("painting", "5", "Tom"));
		school.addStudent(new Student("Tom", "1", "mathematics"));
		school.addStudent(new Student("Jack", "2", "physics"));
		school.addStudent(new Student("Mary", "3", "biology"));
		school.addStudent(new Student("Sunny", "4", "astronomy"));
		school.addStudent(new Student("Kate", "5", "psychology"));
		school.addSelect("maths,Tom");
		school.addSelect("maths,Jack");
		school.addSelect("maths,Mary");
		school.addSelect("maths,Sunny");
		school.addSelect("maths,Kate");
		school.addSelect("computer,Tom");
		school.addSelect("computer,Jack");
		school.addSelect("computer,Mary");
		school.addSelect("computer,Sunny");
		school.addSelect("computer,Kate");
		JFrame frame = new JFrame();
		frame.setSize(640, 960);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){

			      int option = JOptionPane.showConfirmDialog(null, JOptionPane.OK_CANCEL_OPTION);
			      if (JOptionPane.OK_OPTION == option) {

			      System.exit(1);
				}
			}
				});		
		//input field for class
		JTextField xField = new JTextField(5);
		JTextField yField = new JTextField(5);
		JTextField zField = new JTextField(5);
		//input field for student
		JTextField x1Field = new JTextField(5);
		JTextField y1Field = new JTextField(5);
		JTextField z1Field = new JTextField(5);
		//input panel for class
		JPanel classPanel = new JPanel();
		classPanel.add(new JLabel("Class name:"));
		classPanel.add(xField);
		classPanel.add(Box.createHorizontalStrut(15));
		classPanel.add(new JLabel("Class number:"));
		classPanel.add(yField);
		classPanel.add(new JLabel("Class instructor:"));
		classPanel.add(zField);
		//input panel for student
		JPanel studentPanel = new JPanel();
		studentPanel.add(new JLabel("Student name:"));
		studentPanel.add(x1Field);
		studentPanel.add(Box.createHorizontalStrut(15));
		studentPanel.add(new JLabel("Student number:"));
		studentPanel.add(y1Field);
		studentPanel.add(new JLabel("Student major:"));
		studentPanel.add(z1Field);
		//commands
		Object[] options = { "Add a class", "Remove a class", "Add a student",
				"Drop a student", "Roster of a class", "Student's schedule","Total students"};
		int response = 0;
		//always display Pane
		while(response!=-1){
			response = JOptionPane.showOptionDialog(frame,
					"Please choose command", "commands", JOptionPane.YES_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[5]);
			System.out.println("button"+response);
			//Add a class
			if (response == 0) {
				int result = JOptionPane.showConfirmDialog(frame, classPanel,
						"Please Enter Class", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					int size = school.getCourselist().size();
					boolean flag = true;
					if (size > 0) {
						for (int i = 0; i < size; i++) {
							if (school.getCourselist().get(i).getName().equals(
									xField.getText())
									|| school.getCourselist().get(i)
											.getNumber().equals(
													yField.getText())) {
								//check if class exists
								flag = false;
							}
						}
						if (flag) {
							school.addClass(new Course(xField.getText(), yField
									.getText(), zField.getText()));
							System.out.println("Class added: ");
							System.out.println("Class name: "
									+ xField.getText());
							System.out.println("Class number: "
									+ yField.getText());
							System.out.println("Class instructor: "
									+ zField.getText());
						} else {
							JOptionPane.showMessageDialog(null,
									"Class already exist", "Message",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						school.addClass(new Course(xField.getText(), yField
								.getText(), zField.getText()));
						System.out.println("Class added: ");
						System.out.println("Class name: " + xField.getText());
						System.out.println("Class number: " + yField.getText());
						System.out.println("Class instructor: "
								+ zField.getText());
					}

				}
			}
			//Remove a class
			if (response == 1) {
				int size = school.getCourseNamelist().size();
				if (size > 0) {
					String[] arr = (String[]) school.getCourseNamelist()
							.toArray(new String[size]);
					Object a = JOptionPane.showInputDialog(frame,
							"Choose class to remove", null,
							JOptionPane.QUESTION_MESSAGE, null, arr, arr[0]);
					school.removeClass((String) a);
					System.out.println("Class removed: " + a);
				} else {
					JOptionPane.showMessageDialog(null, "no class to remove",
							"Message", JOptionPane.INFORMATION_MESSAGE);
				}

			}
			//Add a student
			if (response == 2) {
				int result = JOptionPane.showConfirmDialog(frame, studentPanel,
						"Please Enter Student", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					int size = school.getStudentlist().size();
					boolean flag = true;
					if (size > 0) {
						for (int i = 0; i < size; i++) {
							if (school.getStudentlist().get(i).getName()
									.equals(x1Field.getText())
									|| school.getStudentlist().get(i)
											.getNumber().equals(
													y1Field.getText())) {
								//check if student exists
								flag = false;
							}
						}
						if (flag) {
							school.addStudent(new Student(x1Field.getText(),
									y1Field.getText(), z1Field.getText()));
							System.out.println("Student added: ");
							System.out.println("Student name: "
									+ x1Field.getText());
							System.out.println("Student number: "
									+ y1Field.getText());
							System.out.println("Student major: "
									+ z1Field.getText());

						}
						size = school.getCourseNamelist().size();
						if (size > 0) {
							String[] arr = (String[]) school
									.getCourseNamelist().toArray(
											new String[size]);
							Object a = JOptionPane.showInputDialog(frame,
									"Choose student's class ", null,
									JOptionPane.QUESTION_MESSAGE, null,
									arr, arr[0]);
							school.addSelect(a+ "," +x1Field.getText());
							System.out.println(a + " added to " + x1Field.getText());
						}						
					} else {
						school.addStudent(new Student(x1Field.getText(),
								y1Field.getText(), z1Field.getText()));
						System.out.println("Student added: ");
						System.out
								.println("Student name: " + x1Field.getText());
						System.out.println("Student number: "
								+ y1Field.getText());
						System.out.println("Student major: "
								+ z1Field.getText());
					}
				}
			}
			//Drop a student
			if (response == 3) {
				int size = school.getCourseNamelist().size();
				if (size > 0) {
					String[] arr = (String[]) school.getCourseNamelist()
							.toArray(new String[size]);
					Object a = JOptionPane.showInputDialog(frame,
							"Choose class to drop", null,
							JOptionPane.QUESTION_MESSAGE, null, arr, arr[0]);
					size = school.getCSlist((String) a).size();
					if (size > 0) {
						arr = (String[]) school.getCSlist((String) a).toArray(
								new String[size]);
						Object b = JOptionPane
								.showInputDialog(frame,
										"Choose student to drop", null,
										JOptionPane.QUESTION_MESSAGE, null,
										arr, arr[0]);
						school.dropSelect(a + "," + b);
						System.out.println(b + " dropped from " + a);
					} else {
						JOptionPane.showMessageDialog(null,
								"no student select the class", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "no class to exist",
							"Message", JOptionPane.INFORMATION_MESSAGE);
				}

			}
			//Roster of a class
			if (response == 4) {
				int size = school.getCourseNamelist().size();
				if (size > 0) {
					String[] arr = (String[]) school.getCourseNamelist()
							.toArray(new String[size]);
					Object a = JOptionPane.showInputDialog(frame,
							"Choose class to check", null,
							JOptionPane.QUESTION_MESSAGE, null, arr, arr[0]);
					size = school.getCSlist((String) a).size();
					if (size > 0) {
						arr = (String[]) school.getCSlist((String) a).toArray(
								new String[size]);
						System.out.println("roster of class "+a+":");						
						for(int i=0;i<size;i++){
							System.out.println(arr[i]);
						}
						System.out.println("total number of students :"+size);						
						JOptionPane
								.showInputDialog(frame,
										"total number of students:" + size,
										"Roster for the course",
										JOptionPane.QUESTION_MESSAGE, null,
										arr, arr[0]);
					} else {
						JOptionPane.showMessageDialog(null,
								"no student select the class", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						;
					}
				} else {
					JOptionPane.showMessageDialog(null, "no class exist",
							"Message", JOptionPane.INFORMATION_MESSAGE);
					;
				}

			}
			//Student's schedule
			if (response == 5) {
				int size = school.studentlist.size();
				if (size > 0) {
					String[] arr = (String[]) school.getStudentNamelist()
							.toArray(new String[size]);
					Object a = JOptionPane.showInputDialog(frame,
							"Choose student to check", null,
							JOptionPane.QUESTION_MESSAGE, null, arr, arr[0]);
					size = school.getSClist((String) a).size();
					if (size > 0) {
						arr = (String[]) school.getSClist((String) a).toArray(
								new String[size]);
						System.out.println(a+"'s schedule :");						
						for(int i=0;i<size;i++){
							System.out.println(arr[i]);
						}						
						JOptionPane
								.showInputDialog(frame, "Student's schedule",
										null, JOptionPane.QUESTION_MESSAGE,
										null, arr, arr[0]);
					} else {
						JOptionPane.showMessageDialog(null,
								"no schedule exist", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						;
					}
				} else {
					JOptionPane.showMessageDialog(null, "no student exist",
							"Message", JOptionPane.INFORMATION_MESSAGE);
					;
				}

			}
			//Total students
			if (response == 6) {
				int size = school.studentlist.size();
					String[] arr = (String[]) school.getStudentNamelist()
							.toArray(new String[size]);
					System.out.println("total number of students in the school :"+size);					
					JOptionPane.showInputDialog(frame,
							"total number of students :"+size, "Total students",
							JOptionPane.QUESTION_MESSAGE, null, arr, arr[0]);
						
			}
		}
	}

	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}