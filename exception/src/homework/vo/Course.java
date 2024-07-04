package homework.vo;

public class Course {

	private int courseNo;				//과정 번호
	private String courseName;			//과정명
	private String courseDept;			//과정 학과
	private int courseGrade;			//과정 학년
	private int currentApplicantNumber;	//현재신청인원
	private int totalApplicantNumber;	//모집인원
	
	public Course() {}

	public Course(int courseNo, String courseName, String courseDept, int courseGrade, int currentApplicantNumber,
			int totalApplicantNumber) {
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseDept = courseDept;
		this.courseGrade = courseGrade;
		this.currentApplicantNumber = currentApplicantNumber;
		this.totalApplicantNumber = totalApplicantNumber;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDept() {
		return courseDept;
	}

	public void setCourseDept(String courseDept) {
		this.courseDept = courseDept;
	}

	public int getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(int courseGrade) {
		this.courseGrade = courseGrade;
	}

	public int getCurrentApplicantNumber() {
		return currentApplicantNumber;
	}

	public void setCurrentApplicantNumber(int currentApplicantNumber) {
		this.currentApplicantNumber = currentApplicantNumber;
	}

	public int getTotalApplicantNumber() {
		return totalApplicantNumber;
	}

	public void setTotalApplicantNumber(int totalApplicantNumber) {
		this.totalApplicantNumber = totalApplicantNumber;
	}
}