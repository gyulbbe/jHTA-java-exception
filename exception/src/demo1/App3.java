package demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App3 {

	/*
	 * throws 키워드로 예외처리 위임하기
	 * 	throws 키워드는 이 메소드내에서 처리해아할 예외를 이 메소드를 호출하는 메소드에게 예외처리를 위임시킨다.
	 * 	아래의 메소드는 ParseException을 발생시키는 기능을 사용하고 있는데, 해당 메소드에 대한 예외처리를 직접 구현하지 않고 throws 키워드로 예외처리를 떠넘기고 있다.
	 */
	public void textToDate(String text) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(text);
		System.out.println(date);
	}
	
	public static void main(String[] args) {
		/*
		 * textToDate() 메소드가 예외처리를 위임했기 때문에 이 메소드를 호출하는 곳에서 예외처리를 작성해야 한다.
		 */
		try {
		App3 app = new App3();
		app.textToDate("2011-01-01");
		} catch (ParseException e) {
			System.out.println("예외발생");
		}
	}
}