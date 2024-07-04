package homework.app;

import java.util.List;

import demo7.vo.User;
import homework.exception.SchoolException;
import homework.service.SchoolService;
import homework.vo.Course;
import homework.vo.Student;
import util.Keyboard;

public class SchoolApp {
	
	private SchoolService schoolService = new SchoolService();

	public void menu() {
		System.out.println("-------------------------------");
		System.out.println("1.개설과정 조회 2.수강신청 3.수강신청 조회");
		System.out.println("4.수강철회 5.학생가입 6.학생목록 조회");
		System.out.println("0.종료");
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println("메뉴선택: ");
		int menuNo = Keyboard.readInt();
		System.out.println();
		
		try {
			if (menuNo == 1) {
				개설과정조회();
			} else if (menuNo == 2) {
				수강신청();
			} else if (menuNo == 3) {
				수강신청조회();
			} else if (menuNo == 4) {
				수강철회();
			} else if (menuNo == 5) {
				학생가입();
			} else if (menuNo == 6) {
				학생조회();
			} else if (menuNo == 0) {
				종료();
			}
		} catch (SchoolException e) {
			System.out.println("------------------------------");
			System.out.println("###[오류발생] " + e.getMessage());
			System.out.println("------------------------------");
		}

		System.out.println();
		menu();
	}
	
	private void 학생가입() {
		
		String id = Keyboard.readString();
		System.out.println("가입할 번호: " + id);
		String name = Keyboard.readString();
		System.out.println("가입할 이름: " + name);
		String dept = Keyboard.readString();
		System.out.println("가입할 학과: " + dept);
		int grade = Keyboard.readInt();
		System.out.println("가입할 학년: " + grade);
		
		Student student = new Student(id, name, dept, grade);
		
		schoolService.addStudent(student);
	}

	private void 수강철회() {
		// TODO Auto-generated method stub
		
	}

	private void 수강신청조회() {
		// TODO Auto-generated method stub
		
	}

	private void 수강신청() {
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();
		System.out.print("과정번호 입력: ");
		int courseNo = Keyboard.readInt();
		
		schoolService.signUp(id, courseNo);
	}

	private void 개설과정조회() {
		System.out.println("### 개설과정 조회");
		List<Course> allCourses = schoolService.findAllCrouses();
		
		System.out.println("------------------------------");
		System.out.println("과정 번호\t과정 이름");
		for(Course course : allCourses) {
			System.out.print(course.getCourseNo() + "\t");
			System.out.print(course.getCourseName());
			System.out.println();
		}
		
	}
	
	private void 학생조회() {
		System.out.println("### 학생정보조회");
		System.out.println("### 조회할 사용자 아이디를 입력하세요.");
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();

		User user = schoolService.getUserInfo(id);
		System.out.println("------------------------------");
		System.out.println("아이디: " + user.getId());
		System.out.println("이름: " + user.getName());
		System.out.println("이메일: " + user.getEmail());
		System.out.println("전화번호: " + user.getTel());
		System.out.println("포인트: " + user.getPoint());
		System.out.println("------------------------------");
	}

	private void 종료() {
		System.out.println("[종료]");
		System.exit(1);
	}
	
	public static void main(String[] args) {
		SchoolApp app = new SchoolApp();
		app.menu();
	}
}
