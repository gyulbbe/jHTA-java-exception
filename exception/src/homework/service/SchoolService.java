package homework.service;

import java.util.List;

import homework.exception.SchoolException;
import homework.repo.CourseRepository;
import homework.repo.RequestRepository;
import homework.repo.StudentReository;
import homework.vo.Course;
import homework.vo.Request;
import homework.vo.Student;

public class SchoolService {

	private CourseRepository courseRepo = new CourseRepository();
	private StudentReository studentRepo = new StudentReository();
	private RequestRepository reqRepo = new RequestRepository();

	// 수강신청 철회
	public void requestWithdrawal(int requestNo) {
		// 수강번호로 수강 신청 객체 불러오기
		Request req = reqRepo.getRequestInfoByNo(requestNo);
		// 수강 신청 객체 매개변수로 넣어서 수강철회
		reqRepo.requestWithdrawal(req);
		// 수강 신청 객체의 과정 번호로 과정 객체 불러오기
		int courseNo = req.getCourseNo();
		Course course = courseRepo.getCourseByNo(courseNo);
		//과정 객체 신청인원 내리기
		int courseApplicantNumber = course.getCurrentApplicantNumber();
		course.setCurrentApplicantNumber(--courseApplicantNumber);
	}
	
	// 수강신청 조회
	public List<Request> getRequestInfo (String id) {
		List<Request> requestList = reqRepo.getRequestInfoById(id);
		if(requestList.isEmpty()) {
			throw new SchoolException("해당하는 수강 번호가 존재하지 않습니다.");
		}
		
		return requestList;
	}
	
	// 수강신청
	public void signUp (String id, int courseNo) {
		
		Course course = courseRepo.getCourseByNo(courseNo);
		Student student = studentRepo.getStudentById(id);
		// 과정을 찾지 못했을 때
		if(course == null) {
			throw new SchoolException("과정이 존재하지 않습니다.");
		}
		// 학생을 찾지 못했을 때
		if(student == null) {
			throw new SchoolException("존재하지 않는 아이디입니다.");
		}
		// 모집 인원과 신청 인원이 같을 때
		if(course.getCurrentApplicantNumber() == course.getTotalApplicantNumber()) {
			throw new SchoolException("신청 인원이 가득 찼습니다.");
		}	
		Request req = new Request();
		req.setCourseNo(course.getCourseNo());
		req.setCourseName(course.getCourseName());
		req.setCourseDept(course.getCourseDept());
		req.setId(id);
		reqRepo.signUp(req);
		
		// 신청인원 1증가
		int CurrentApplicantNumber = course.getCurrentApplicantNumber();
		course.setCurrentApplicantNumber(++CurrentApplicantNumber);
	}
	
	// 개설된 모든 과정 조회
	public List<Course> findAllCrouses() {
		List<Course> allCourses = courseRepo.findAllCourses();
		return allCourses;
	}
	
	// 학생가입
	public void addStudent(Student student) {
		studentRepo.addStudent(student);
	}

	// 학생 조회
	public Student getUserInfo(String id) {
		Student student = studentRepo.getStudentById(id);
		if(student == null) {
			throw new SchoolException("존재하지 않는 아이디입니다.");
		}
		
		return student;
	}
	
}
