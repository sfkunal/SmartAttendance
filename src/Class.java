//kunal srivastava 11pm 6/24/18

import java.util.*;
import java.time.*;


public class Class {

	private String name; //name for each class
	private ArrayList<Student> registeredStudents = new ArrayList<>(); //list of registered students (total)
	private Map<String, Student> studentDatabase = new HashMap<String, Student>(); //student database (same as one in main class
	private ArrayList<Student> presentStudents = new ArrayList<Student>(); //list of present students
	private ArrayList<Student> absentStudents = new ArrayList<Student>(); //list of absent students
	private ArrayList<Student> tardyStudents = new ArrayList<Student>(); //list of tardy students
	private ArrayList<String> registeredIDs = new ArrayList<String>(); //list of the IDs of registered Students
	private LocalTime startTime; //the time each class starts at

	//constructor for each class including name, startTime, registeredStudents, and studentDatabase
	public Class(String name, LocalTime startTime, ArrayList<Student> registeredStudents, Map<String, Student> studentDatabase) {
		this.startTime = startTime;
		this.setClassName(name);
		this.studentDatabase = studentDatabase;
		this.registeredStudents = registeredStudents;
	}

	//compares the current time and class start time to see if student is tardy or on-time
	private int compareTime() {
		LocalTime currentTime = LocalTime.now();
		return currentTime.compareTo(startTime);
	}

	//POST METHOD
	//UPDATE AT 11PST: method is working as expected with present, tardy, and absent all functional
	public void addStudents(String studentId) {
		Student student = new Student();
		System.out.println("enter student id of student to be added to class (type 'done' when done)");
		if (studentDatabase.containsKey(studentId)) {
			student = studentDatabase.get(studentId);
			//finds student based on ID
		} else if (!studentId.equals("done")) {
			System.out.println("that ID is not registered in this class");
			System.out.println();
			//checks for unregistered ID (meaning student is not enrolled in class)
		}
		if (compareTime() > 0) {
			tardyStudents.add(student);
			System.out.println(studentDatabase.get(studentId).getStudentName() + " checked in and tardy at " + LocalTime.now());
			System.out.println();
			//this is the tardy check
		} else {
			presentStudents.add(student);
			System.out.println(studentDatabase.get(studentId).getStudentName() + " checked in and on-time at " + LocalTime.now());
			System.out.println();
			//this is the on-time (present) check
		}
		for(int i = 0; i < registeredStudents.size(); i++) {
			registeredIDs.add(registeredStudents.get(i).getID());
			//registeredIDs is set to the IDs of registeredStudents
		}
		absentStudents = registeredStudents;
		//absentStudents is set to registeredStudents
		Student stu = new Student();
		for(int i = 0; i < registeredStudents.size(); i++) {
			stu = registeredStudents.get(i);
			if(presentStudents.contains(stu) || tardyStudents.contains(stu)) {
				absentStudents.remove(stu);
				//if a student is present or tardy, it is removed from the absentStudents list
			}
		}
	}

	//POST METHOD (this can be done later, not a priority0)
	public void removeStudent(String studentId) {
		for (int i = 0; i < registeredStudents.size(); i++) {
			if (studentId.equals(registeredStudents.get(i).getID())) {
				registeredStudents.remove(i);
				//removes the student from registeredStudents
			}
		}

	}

	private String listToString(ArrayList<Student> l) {
		//this is effectively some form of a toString method
		String list = "";
		for (int i = 0; i < l.size(); i++) {
			list += studentDatabase.get(l.get(i).getID()).getStudentName() + " ";
		}
		if (l.isEmpty()) return "NO STUDENTS";
		return list;
	}

	public String printList(String str) {
		//a list is printed based upon a keyword provided (present, tardy, or absent)
		switch (str) {
		case "present":
			return("present students: " + listToString(presentStudents));
		case "tardy":
			return("tardy students: " + listToString(tardyStudents));
		case "absent":
			return("absent students: " + listToString(absentStudents));
		}
		return "";
	}

	//returns class name
	public String getClassName() {
		return name;
	}

	//sets class name
	public void setClassName(String name) {
		this.name = name;
	}

	//returns registeredStudents
	public ArrayList<Student> getRegistered() {
		return registeredStudents;
	}

	//returns presentStudents
	public ArrayList<Student> getPresent() {
		return presentStudents;
	}

	//returns tardyStudents
	public ArrayList<Student> getTardy() {
		return tardyStudents;
	}

	//returns absentStudents
	public ArrayList<Student> getAbsent() {
		return absentStudents;
	}
}
