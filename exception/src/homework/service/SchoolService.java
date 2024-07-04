package homework.service;

import java.util.ArrayList;
import java.util.List;

import demo7.vo.User;
import homework.exception.SchoolException;
import homework.repo.CourseRepository;
import homework.repo.RequestRepository;
import homework.repo.StudentReository;
import homework.vo.Course;
import homework.vo.Student;

public class SchoolService {

	private CourseRepository courseRepo = new CourseRepository();
	private StudentReository studentRepo = new StudentReository();
	private RequestRepository reqRepo = new RequestRepository();
	
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
		reqRepo.signUp(id, course);
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
	public User getUserInfo(String id) {
		return null;
	}
	
}
