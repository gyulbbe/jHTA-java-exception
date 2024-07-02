package demo5;

import java.io.FileWriter;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		
		try (FileWriter writer = new FileWriter("a.txt")){
			writer.write("안녕하세요");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}