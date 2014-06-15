import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SchoolTester {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		School school;
		File f = new File("school.dat");
		if (f.exists()) {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			school = (School) in.readObject();
			in.close();
			System.out.println("read student list from file...");
		} else {
			school = new School();
			school.addStudent(new Student("Tom", "1", "mathematics", 2.7));
			school.addStudent(new Student("Jack", "2", "physics", 2.0));
			school.addStudent(new Student("Mary", "3", "biology", 2.88));
			school.addStudent(new Student("Sunny", "4", "astronomy", 2.5));
			school.addStudent(new Student("Kate", "5", "psychology", 2.4));
			System.out.println("creat new student list...");			
		}
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(f));
		out.writeObject(school);
		out.close();		
		school.printStudent();
	}

}