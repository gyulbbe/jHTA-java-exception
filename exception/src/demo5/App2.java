package demo5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App2 {

	public static void main(String[] args) {
		
		/*
		 * try ~ with ~ resource 블록
		 * 	java.lang.AutoCloseable 인터페이스를 구현한 객체는 try ~ with ~ resource 블록을 사용해서 자동 자원 반납 서비스를 받을 수 있다.
		 * 	try ~ with ~ resource 블록에서 생성된 객체는 예외발생여부와 상관없이 try ~ with ~ resource 구문이 종료될 때 자동으로 자원을 반납시키는 메소드를 실행시킨다.
		 * 	java7 부터 지원된다.
		 */
		
		try (
				FileReader reader = new FileReader("a.txt");
				FileWriter writer = new FileWriter("b.txt");
				){
			writer.write("try ~ with ~ resource 블록 연습");
			writer.write("try ~ with ~ resource 블록 연습");
			writer.write("try ~ with ~ resource 블록 연습");
			writer.write("try ~ with ~ resource 블록 연습");
			writer.write("try ~ with ~ resource 블록 연습");
			writer.write("try ~ with ~ resource 블록 연습");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}