package demo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App1 {

	public static void main(String[] args) {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse("2011-11-");
			System.out.println(date);
		} catch (ParseException e) {
			// 오류에 대한 상세한 정보를 문자열로 반환한다.
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);
			
			// 오류 해결을 위한 디버깅 작업에 필요한 모든 정보를 출력
			// 예외클래스 이름, 오류 메시지, 케소드 실행 순서 등
			// 개발단계에서는 catch블록에 꼭 작성해야되는 수행문이다.
			e.printStackTrace();
		}
	}
}