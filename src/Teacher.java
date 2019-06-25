//kunal srivastava 8:27am 6/24/18

public class Teacher {

	//each teacher will own a class
	private Class theClass;
	//each teacher has a name
	private String name;

	//constructor for a teacher with a name and class
	public Teacher(String name, Class theClass) {
		this.theClass = theClass;
		this.name = name;
	}

	//starts attendance-taking process, accepting a studentID as input
	public void initiateAttendance(String studentID) {
		theClass.addStudents(studentID);
	}

	//allows teacher to manually remove a student from the registered roster
	public void manualRemoveStudentFromClass(String studentID) {
		theClass.removeStudent(studentID);
	}

	//returns teacher name
	public String getTeacherName() {
		return name;
	}

	//sets teacher name
	public void setTeacherName(String name) {
		this.name = name;
	}

	//GET method
	public String returnPresent() {
		return theClass.printList("present");

	}
	//GET method
	public String returnTardy() {
		return theClass.printList("tardy");


	}
	//GET method
	public String returnAbsent() {
		return theClass.printList("absent");

	}
}
