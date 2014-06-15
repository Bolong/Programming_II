import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SchoolRoster extends JFrame{
	
	JTextField Number;
	JTextField Name;
	JTextField Major;
	JTextField Qpa;
	JButton Add;
	JButton Update;
	JButton Delete;
	JButton Retrieve;
	JPanel P1;
	JPanel P2;
	JTextArea Show;
	JTabbedPane p;
	Box baseBox, baseBox2, boxV1, boxV2;
	School school;
	
	SchoolRoster(String s) throws FileNotFoundException, IOException, ClassNotFoundException{
		super(s);
		final File f = new File("school.dat");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		school = (School) in.readObject();
		in.close();		
		Container con = getContentPane();
		Show = new JTextArea();
		p = new JTabbedPane();
		P1 = new JPanel();
		P2 = new JPanel();

		Number = new JTextField(4);
		Name = new JTextField(6);
		Major = new JTextField(20);
		Qpa = new JTextField(8);

		Add = new JButton("Add");
		Delete = new JButton("Delete");
		Update = new JButton("Update");
		Retrieve = new JButton("Retrieve");

		boxV1 = Box.createVerticalBox();
		boxV1.add(new JLabel("Number:"));
		boxV1.add(Box.createVerticalStrut(31));
		boxV1.add(new JLabel("Name:"));
		boxV1.add(Box.createVerticalStrut(31));
		boxV1.add(new JLabel("Major:"));
		boxV1.add(Box.createVerticalStrut(31));
		boxV1.add(new JLabel("Qpa:"));
		boxV2 = Box.createVerticalBox();
		boxV2.add(Number);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(Name);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(Major);
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(Qpa);
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV2);


		p.add("Input number to retrieve", baseBox);
		p.add("Roster", new JScrollPane(Show));
		p.validate();

		P2.add(Add);
		P2.add(Retrieve);		
		P2.add(Update);
		P2.add(Delete);		
		con.add(p, BorderLayout.CENTER);
		con.add(P2, BorderLayout.SOUTH);
		con.validate();
		setBounds(0, 0, 333, 333);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Add.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) {
						if(!school.isExist(Number.getText())){
						school.studentlist.add(new Student(Name.getText(), Number.getText(), Major.getText(), Double.parseDouble(Qpa.getText())));
						Show.setText(school.listStudent());	
						try {
							ObjectOutputStream out = new ObjectOutputStream(
									new FileOutputStream(f));
							out.writeObject(school);
							out.close();							
						} catch (Exception a) {
							System.out.println(a);
						}						
						}else {
							Number.setText("Number already exist");
							Name.setText("");
							Major.setText("");
							Qpa.setText("");
						}

					}
				});

		Update.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e2) {
						Student std = new Student(Name.getText(), Number.getText(), Major.getText(), Double.parseDouble(Qpa.getText()));
						school.updateStudent(std);
						Show.setText(school.listStudent());							
						try {
							ObjectOutputStream out = new ObjectOutputStream(
									new FileOutputStream(f));
							out.writeObject(school);
							out.close();							
						} catch (Exception a) {
							System.out.println(a);
						}

					}

				});



		Retrieve.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) {
						String id = Number.getText(); 
						Student find = school.retrieveStudent(id);
						if(find!=null){
						Name.setText(find.getName());
						Number.setText(find.getNumber());
						Major.setText(find.getMajor());
						Qpa.setText(String.valueOf(find.getQpa()));
						}else {
							Number.setText("there is no this number");
						}
					}
				});

		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				school.deleteStudent(Number.getText());
				Show.setText(school.listStudent());							
				try {
					ObjectOutputStream out = new ObjectOutputStream(
							new FileOutputStream(f));
					out.writeObject(school);
					out.close();							
				} catch (Exception a) {
					System.out.println(a);
				}

			}
		});

	
	}
	
	
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
		SchoolRoster myschool = new SchoolRoster("SchoolRoster");
		myschool.Show.setText(school.listStudent());
	}		

}