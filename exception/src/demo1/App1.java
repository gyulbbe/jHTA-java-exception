package demo1;

public class App1 {

	public static void main(String[] args) {
		
		System.out.println("### 프로그램 시작");
		
		/*
		 * int Integer.parseInt(String text) throws NumberFormatException
		 *  문자열을 전달받아서 정수로 변환하고 반환하는 메소드
		 *  반환타입 : int
		 *  매개변수 : String
		 *  예외 : NumberFormatException
		 *  	RuntimeException의 하위 클래스다.
		 *  	unCheckedException(예외처리 여부를 체크하지 않는 예외)이다.
		 */
		int value = Integer.parseInt("123a");
		System.out.println(value);

		System.out.println("### 프로그램 종료");
	}
}