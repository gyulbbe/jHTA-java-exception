package demo6;

public class App1 {

	public static void main(String[] args) {
		System.out.println("### 프로그램 시작");
		
		String text = "123a";
		
		try {
			int num = Integer.parseInt(text);
			System.out.println(num);
		} catch (NumberFormatException e) {
			
		}
		
		System.out.println("### 프로그램 종료");
	}
}