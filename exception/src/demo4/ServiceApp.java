package demo4;

import java.util.Date;

public class ServiceApp {

	public static void main(String[] args) {
		
		SampleService service = new SampleService();
		
		Date date = service.textToDate("111111");
		System.out.println(date);
	}
}