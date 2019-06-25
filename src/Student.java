//kunal srivastava 10:43pm 6/24/18

public class Student {

	//student will only have a name and ID
	private String name;
	private String id;

	//simple constructor
	public Student(String id, String name) {
		this.setId(id);
		this.name = name;
	}

	//default constructor
	public Student() {
		this.id = null;
		this.name = "unspecified student";
	}

	//returns ID
	public String getID() {
		return id;
	}

	//sets ID
	public void setId(String id) {
		this.id = id;
	}

	//returns studentName
	public String getStudentName() {
		return name;
	}

	//sets studentName
	public void setStudentName(String name) {
		this.name = name;
	}
}
