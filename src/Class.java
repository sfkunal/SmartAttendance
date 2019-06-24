//kunal srivastava 8:27am 6/24/18

import java.util.*;
import java.time.*;

public class Class {

	private String name;
	private ArrayList<Student> registeredStudents = new ArrayList<>();
	private Map<String, Student> hm = new HashMap<String, Student>();
	private ArrayList<Student> presentStudents = new ArrayList<Student>();
	private ArrayList<Student> absentStudents = new ArrayList<Student>();
	private ArrayList<Student> tardyStudents = new ArrayList<Student>();
	private LocalTime startTime;
	private Scanner sc = new Scanner(System.in);
	
	public Class(String name, LocalTime startTime, ArrayList<Student> registeredStudents, Map<String, Student> hm) {
		this.startTime = startTime;
		this.setClassName(name);
		this.hm = hm;
		this.registeredStudents = registeredStudents;
	}
	
	private int compareTime() {
		LocalTime currentTime = LocalTime.now();  
		return currentTime.compareTo(startTime);
	}

	public void addStudents() {
		ArrayList<Boolean> inClass = new ArrayList<Boolean>(registeredStudents.size());
		for(int i = 0; i < registeredStudents.size(); i++) {
			inClass.add(false);
		}
		
		ArrayList<String> registeredIDs = new ArrayList<String>();
		for(int i = 0; i < registeredStudents.size(); i++) {
			registeredIDs.add(registeredStudents.get(i).getId());
		}
		Student student = new Student();
		String studentId;
		while(true) {
			System.out.println("enter student id of student to be added to class (type 'done' when done)");
			studentId = sc.nextLine();
			if(hm.containsKey(studentId)) {
				student = hm.get(studentId);
			} else if(!studentId.equals("done")){
				System.out.println("that ID is not registered in this class");
				System.out.println();
				continue;
			} else if(studentId.equals("done")) {
				break;
			}
			if(compareTime() > 0) {
				tardyStudents.add(student);
				inClass.set(registeredIDs.indexOf(studentId), true);
				System.out.println(hm.get(studentId).getStudentName() + " checked in and tardy at " + LocalTime.now());
				System.out.println();
			} else {
				presentStudents.add(student);
				inClass.set(registeredIDs.indexOf(studentId), true);
				System.out.println(hm.get(studentId).getStudentName() + " checked in and on-time at " + LocalTime.now());
				System.out.println();
			}
		}
		for(int i = 0; i < inClass.size(); i++) {
			if(inClass.get(i) == false) {
				absentStudents.add(registeredStudents.get(i));
			}
		}
	}

	public void removeStudent() {
		String studentId;
		while(true) {
			studentId = sc.nextLine();
			System.out.println("enter student id of student to be removed from class (type 'done' when done)");
			if(studentId.equals("done")) {
				break;
			} else {
				for(int i = 0; i < presentStudents.size(); i++) {
					if(studentId.equals(presentStudents.get(i).getId())) {
						presentStudents.remove(i);
					}
				}
			}
		}
	}
	
	private String listToString(ArrayList<Student> l) {
		String list = "";
		for(int i = 0; i < l.size(); i++) {
			list += hm.get(l.get(i).getId()).getStudentName() + " ";
		}
		if(l.isEmpty()) return "NO STUDENTS";
		return list;
	}
	
	public void printList(String str) {
		switch(str) {
		case "present": System.out.println("present students: " + listToString(presentStudents));
		break;
		case "tardy": System.out.println("tardy students: " + listToString(tardyStudents));
		break;
		case "absent": System.out.println("absent students: " + listToString(absentStudents));
		break;
		}
	}

	public String getClassName() {
		return name;
	}

	public void setClassName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getRegistered() {
		return registeredStudents;
	}
	public ArrayList<Student> getPresent() {
		return presentStudents;
	}
	public ArrayList<Student> getTardy() {
		return tardyStudents;
	}
	public ArrayList<Student> getAbsent() {
		return absentStudents;
	}
}
