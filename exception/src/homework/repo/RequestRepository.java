package homework.repo;

import java.util.ArrayList;
import java.util.List;

import homework.vo.Course;
import homework.vo.Request;

public class RequestRepository {

	private List<Object> db = new ArrayList<Object>();
	// 수강신청 번호
	private int requestSequence = 1000;
	
	public RequestRepository (String id, Course course) {
		db.add(requestSequence++, course.getCourseNo(), course.getCourseName(), course.getCourseDept(), id, false);

	}
}
