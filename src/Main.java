//kunal srivastava 8:27am 6/24/18

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public final static ArrayList<Student> registeredStudents = new ArrayList<>();	
	private static final Map<String, Student> studentDatabase = new HashMap<String, Student>();

	public static void main(String[] args) {
		addElements();

		Class apcs = new Class("period 2 apcs", LocalTime.of(12, 00, 00), registeredStudents, studentDatabase);
		Teacher MrPaley = new Teacher("mr paley", apcs);		

		MrPaley.initiateAttendance();
		MrPaley.displayResults();		
	}

	private static void addElements() {
		registeredStudents.add(new Student("1", "st1"));
		registeredStudents.add(new Student("2", "st2"));
		registeredStudents.add(new Student("3", "st3"));
		registeredStudents.add(new Student("4", "st4"));
		registeredStudents.add(new Student("5", "st5"));

		for(int i = 0; i < registeredStudents.size(); i++) {
			studentDatabase.put(registeredStudents.get(i).getId(), registeredStudents.get(i));
		}
	}
}
