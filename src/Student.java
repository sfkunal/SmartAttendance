//kunal srivastava 8:27am 6/24/18

public class Student {
	private String name;
	private String id;

	public Student(String id, String name) {
		this.setId(id);
		this.name = name;
	}

	public Student() {
		this.id = null;
		this.name = "unspecified student";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentName() {
		return name;
	}

	public void setStudentName(String name) {
		this.name = name;
	}
}
