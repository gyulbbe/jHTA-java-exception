package demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App2 {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * Date parse(String text) throws ParseException
		 * 	문자열을 해석해서 Date로 변환하고 반환한다.
		 * 	예외발생 : ParseException
		 * 		Exception의 하위 클래스다.
		 * 		CheckedException이다.
		 * 		(컴파일러가 예외처리 여부를 체크하는 예외)
		 */
		try {
			Date date = sdf.parse("2024-01-01");
			System.out.println(date);
		} catch (ParseException e) {
			System.out.println("예외발생");
			// 디버깅에 필요한 정보를 출력시킨다.
			e.printStackTrace();
		}
	}
}