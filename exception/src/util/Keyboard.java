package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 키보드 입력을 읽어오는 메소드가 정의되어 있는 유틸 클래스
 */
public class Keyboard {

	private static BufferedReader in;
	static {
		try {
			in = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		} catch (IOException e) {}
	}
	/**
	 * 키보드 입력을 읽어서 문자열로 반환한다.
	 * @return 키보드로 입력한 문자열
	 */
	public static String readString() {
		try {
			return in.readLine();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	/**
	 * 키보드 입력을 읽어서 정수로 반환한다.
	 * @return 키보드로 입력한 숫자, 숫자가 아닌 문자열을 입력하면 예외가 발생한다.
	 */
	public static int readInt() {
		try {
			String text = in.readLine();
			return Integer.parseInt(text);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	/**
	 * 키보드 입력을 읽어서 정수로 반환한다.
	 * @return 키보드로 입력한 숫자, 숫자가 아닌 문자열을 입력하면 예외가 발생한다.
	 */
	public static long readLong() {
		try {
			String text = in.readLine();
			return Long.parseLong(text);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	/**
	 * 키보드 입력을 읽어서 실수로 반환한다.
	 * @return 키보드로 입력한 소숫점이 포함된 숫자, 숫자가 아닌 문자열을 입력하면 예외가 발생한다.
	 */
	public static double readDouble() {
		try {
			String text = in.readLine();
			return Double.parseDouble(text);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}