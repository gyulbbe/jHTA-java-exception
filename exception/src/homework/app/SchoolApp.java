package homework.app;

import java.util.List;

import homework.exception.SchoolException;
import homework.service.SchoolService;
import homework.vo.Course;
import homework.vo.Request;
import homework.vo.Student;
import util.Keyboard;

public class SchoolApp {
	
	private SchoolService schoolService = new SchoolService();

	public void menu() {
		System.out.println("-------------------------------");
		System.out.println("1.개설과정 조회 2.수강신청 3.수강신청 조회");
		System.out.println("4.수강철회 5.학생가입 6.학생정보 조회");
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
		
		System.out.print("가입할 학생 아이디: ");
		String id = Keyboard.readString();
		System.out.print("가입할 학생 이름: ");
		String name = Keyboard.readString();
		System.out.print("가입할 학생 학과: ");
		String dept = Keyboard.readString();
		System.out.print("가입할 학생 학년: ");
		int grade = Keyboard.readInt();
		
		
		Student student = new Student(id, name, dept, grade);
		
		schoolService.addStudent(student);
	}

	private void 수강철회() {
		System.out.println("### 수강 신청 철회");
		System.out.print("조회할 수강 신청 번호: ");
		int requestNo = Keyboard.readInt();
		
		schoolService.requestWithdrawal(requestNo);
		System.out.println("### 수강 철회가 완료되었습니다.");
	}

	private void 수강신청조회() {
		System.out.println("### 수강신청 조회");
		System.out.print("조회할 수강 신청 아이디: ");
		String id = Keyboard.readString();
		
		List<Request> requests = schoolService.getRequestInfo(id);
		System.out.println("------------------------------");
		System.out.println("수강 신청 번호 아이디\t과정 이름\t수강 철회 여부");
		for(Request req : requests) {
			System.out.print(req.getRequestNo() + "\t");
			System.out.print(req.getId() + "\t");
			System.out.print(req.getCourseName() + "\t");
			System.out.print(req.isWithdrawalStatus());
		}
		
	}

	private void 수강신청() {
		System.out.println("### 수강신청");
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();
		System.out.print("과정번호 입력: ");
		int courseNo = Keyboard.readInt();
		
		schoolService.signUp(id, courseNo);
		System.err.println("수강신청이 완료되었습니다.");
	}

	private void 개설과정조회() {
		System.out.println("### 개설과정 조회");
		List<Course> allCourses = schoolService.findAllCrouses();
		
		System.out.println("------------------------------");
		System.out.println("과정 번호\t과정 이름\t현재 신청 인원");
		for(Course course : allCourses) {
			System.out.print(course.getCourseNo() + "\t");
			System.out.print(course.getCourseName() + "\t");
			System.out.println(course.getCurrentApplicantNumber());
			System.out.println();
		}
		
	}
	
	private void 학생조회() {
		System.out.println("### 학생정보조회");
		System.out.println("### 조회할 사용자 아이디를 입력하세요.");
		System.out.print("아이디 입력: ");
		String id = Keyboard.readString();

		Student student = schoolService.getUserInfo(id);
		System.out.println("------------------------------");
		System.out.println("아이디: " + student.getId());
		System.out.println("이름: " + student.getName());
		System.out.println("학과: " + student.getDept());
		System.out.println("학년: " + student.getGrade());
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
