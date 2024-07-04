package homework.repo;

import java.util.ArrayList;
import java.util.List;

import homework.vo.Course;

public class CourseRepository {
	
	private List<Course> db = new ArrayList<Course>();
	// 과정 번호
	private int courseSequence = 1000;
	
	public CourseRepository() {
		db.add(new Course(courseSequence++, "수학", "이과", 1, 10, 20));
		db.add(new Course(courseSequence++, "영어", "이과", 1, 10, 20));
		db.add(new Course(courseSequence++, "국어", "이과", 1, 10, 20));
		db.add(new Course(courseSequence++, "수학", "문과", 1, 10, 20));
		db.add(new Course(courseSequence++, "영어", "문과", 1, 10, 20));
		db.add(new Course(courseSequence++, "국어", "문과", 1, 10, 20));
	}
	
	/**
	 * @return 모든 과정 정보
	 */
	public List<Course> findAllCourses (){
		return db;
	}
	
	/**
	 * @param courseNo 과정 번호
	 * @return 과정 객체
	 */
	public Course getCourseByNo (int courseNo) {
		Course course = null;
		
		for(Course c : db) {
			if(c.getCourseNo() == courseNo) {
				course = c;
			}
		}
		
		return course;
	}
}