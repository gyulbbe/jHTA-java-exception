package demo1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App5 {

	public static void main(String[] args) {
		App5 app = new App5();
		
		/*
		 * 예외를 일괄처리하는 곳에는 catch 블록을 여러개 작성해서 예외를 처리할 수 있다.
		 */
		try {
			app.test1("2021-01-01");
			app.test2("안녕하세요.");
			app.test3();
		} catch (ParseException e) {
			System.out.println("날짜 변환 예외 발생");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없는 예외 발생");
		} catch (IOException e) {
			System.out.println("읽고 쓰기 예외 발생");
		}
		
		/*
		 * catch 블록의 괄호안에서 |기호를 사용해서 여러 개의 예외를 한번에 가로챌 수 있다.
		 */
		try {
			app.test1("2021-01-01");
			app.test2("안녕하세요.");
			app.test3();
		} catch (ParseException | IOException e) {
			System.out.println("예외 발생");
		}
	}
	
	public void test1(String text) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(text);
		System.out.println(date);
	}
	
	public void test2(String text) throws IOException{
		FileWriter writer = new FileWriter("src/demo1/sample.txt");
		writer.write(text);
		writer.flush();
		writer.close();
	}
	
	public void test3() throws FileNotFoundException {
		FileReader reader = new FileReader("src/demo1/sample2.txt");
	}
}