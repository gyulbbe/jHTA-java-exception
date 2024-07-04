package homework.vo;

public class Student {

	private String id;
	private String name;
	private String dept;
	private int grade;
	
	public Student () {}
	
	public Student(String id, String name, String dept, int grade) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
