package demo1;

import java.io.FileWriter;
import java.io.IOException;

public class App4 {

	public void writeText(String text) throws IOException {
		FileWriter writer = new FileWriter("src/demo1/sample.txt");
		writer.write(text);
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * main 메소드에서도 throws 케워드로 예외처리를 위임할 수 있다.
		 * 이 경우 main 메소드를 호출한 JVM에게 예외처리를 위임하는 것이다.
		 * 이 경우 예외처리를 하지 않는 것과 동일하다.
		 * (예외처리는 발생한 예외를 가로채고, JVM에게 예외가 전달되지 못하는 것이기 때문이다.)
		 */
		App4 app = new App4();
		app.writeText("연습입니다.");
	}
}
