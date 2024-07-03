package demo5;

import java.io.FileWriter;
import java.io.IOException;

public class App {

	public static void main(String[] args) {

		/*
		 * try ~ cath ~ finally
		 * 	fianlly 블록은 예외발생과 상관없이 반드시 수행할 작업을 포함하는 블록이다.
		 * 	애플리케이션 실행 중 사용했떤 시스템의 자원을 반납하는 수행문을 포함한다.
		 * 
		 * try ~ finally
		 * 	try 블록에서 사용하는 메소드가 UnchekedException이면 catch블록을 생략할 수 있다.
		 */
		
		// try 블록과 finally 블록에서 writer 참조변수를 사용하기 때문에 블록 바깥에서 변수 정의
		FileWriter writer = null;
		
		try {
			// 컴퓨터의 입출력 자원을 사용하는 스트림객체 생성
			writer = new FileWriter("a.txt");
			
			// 컴퓨터의 입출력 자원을 활용해서 파일에 내용 기록하기
			writer.write("안녕하세요.");
			writer.write("안녕하세요.");
			writer.write("안녕하세요.");
			writer.write("안녕하세요.");
			writer.write("안녕하세요.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 자원을 반납하는 수행문을 실행한다.
			try {
				if(writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				// 특별한 수행문을 실행할 필요없음
			}
		}
		
		// 위의 코드가 try-with-resource가 생기면서 아래처럼 간단하게
//		try (FileWriter writer = new FileWriter("a.txt")){
//			writer.write("안녕하세요");
//			writer.write("안녕하세요");
//			writer.write("안녕하세요");
//			writer.write("안녕하세요");
//			writer.write("안녕하세요");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}