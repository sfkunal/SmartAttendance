//kunal srivastava 10:43pm 6/24/18

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private final static ArrayList<Student> registeredStudents = new ArrayList<>();
	private static final Map<String, Student> studentDatabase = new HashMap<String, Student>();


	public static void main(String[] args) {
		registeredStudents.add(new Student("1", "st1"));
		registeredStudents.add(new Student("2", "st2"));
		registeredStudents.add(new Student("3", "st3"));
		registeredStudents.add(new Student("4", "st4"));
		registeredStudents.add(new Student("5", "st5"));

		addStudentsToDatabase();
		//hard-codes the map of student ID to student name

		Class apcs = new Class("period 2 apcs", LocalTime.of(16, 15, 00), registeredStudents, studentDatabase);
		//instantiates a class
		Teacher MrPaley = new Teacher("mr paley", apcs);
		//instantiates a teacher

		MrPaley.initiateAttendance("1");
		MrPaley.initiateAttendance("3");
		//simple example of logic in initiateAttendance working as expected

		System.out.println(MrPaley.returnPresent());
		System.out.println(MrPaley.returnTardy());
		System.out.println(MrPaley.returnAbsent());
		//three methods to return desired lists
	}

	private static void addStudentsToDatabase() {
		for(int i = 0; i < registeredStudents.size(); i++) {
			studentDatabase.put(registeredStudents.get(i).getID(), registeredStudents.get(i));
			//adding students to a database(map) from the roster
		}
	}
}
