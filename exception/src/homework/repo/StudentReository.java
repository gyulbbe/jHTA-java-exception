package homework.repo;

import java.util.HashMap;
import java.util.Map;

import homework.vo.Student;

public class StudentReository {

	private Map<String, Student> map = new HashMap<String, Student>();

	public StudentReository() {
		map.put("hong", new Student("hong", "홍길동", "문과", 1));
		map.put("kim", new Student("kim", "김유신", "문과", 1));
		map.put("ryu", new Student("ryu", "류관순", "문과", 1));
		map.put("kang", new Student("kang", "강감찬", "이과", 1));
		map.put("park", new Student("park", "박혁거세", "이과", 1));
		map.put("gwang", new Student("gwang", "광개토대왕", "이과", 1));
	}

	// 학생 가입
	public void addStudent(Student student){
//		map.put(student.getId(), new Student(student.getId(), student.getName(), student.getDept(), student.getGrade()));
		map.put(student.getId(),student);
	}
	
	// 학생 조회
	public Student getStudentById(String id) {
		Student student = map.get(id);
		return student;
	}
}