//kunal srivastava 8:27am 6/24/18

public class Teacher {

	private Class theClass;
	private String name;

	public Teacher(String name, Class theClass) {
		this.theClass = theClass;
		this.name = name;
	}

	public void initiateAttendance() {
		theClass.addStudents();
	}

	public void manualRemoveStudentFromClass() {
		theClass.removeStudent();
	}

	public String getTeacherName() {
		return name;
	}
	public void setTeacherName(String name) {
		this.name = name;
	}

	public void displayResults() {
		theClass.printList("present");
		theClass.printList("tardy");
		theClass.printList("absent");
	}
}
