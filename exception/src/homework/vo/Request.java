package homework.vo;

public class Request {

	private int requestNo;				//수강신청 번호
	private int courseNo;				//과정 번호
	private String courseName;			//과정 명
	private String courseDept;			//과정 학과
	private String id;					//학생 아이디
	private boolean WithdrawalStatus;	//철회여부
	
	public Request() {}
	
	public Request(int requestNo, int courseNo, String courseName, String courseDept, String id,
			boolean withdrawalStatus) {
		this.requestNo = requestNo;
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseDept = courseDept;
		this.id = id;
		WithdrawalStatus = withdrawalStatus;
	}
	
	public int getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isWithdrawalStatus() {
		return WithdrawalStatus;
	}

	public void setWithdrawalStatus(boolean withdrawalStatus) {
		WithdrawalStatus = withdrawalStatus;
	}
	
	
}