package util;

public class NumberUtils {

	/**
	 * 문자열과 기본값을 전달받아서 정수로 변환해서 반환한다.
	 * @param text 문자열
	 * @param defaultValue 기본값
	 * @return 정수값, 문자열을 숫자로 변환할 수 없을 때는 기본값이 반환된다.
	 */
	public static int toInt(String text, int defaultValue) {
		if(text == null) {
			return defaultValue;
		}
		if (text.isBlank()) {
			return defaultValue;
		}
		text = text.trim();
		try {
			int value = Integer.parseInt(text);
			return value;
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
	
	/**
	 * 숫자로 구성된 문자열을 전달받아서 정수로 변환해서 반환한다.
	 * @param text 문자열
	 * @return 정수값
	 */
	public static int toInt(String text) {
		return toInt(text, 0);
		
		//위의 toInt메소드 가 추가되면서 위의 return문 하나만으로 아래의 코드 삭제가 가능
//		if(text == null) {
//			return 0;
//		}
//		if (text.isBlank()) {
//			return 0;
//		}
//		text = text.trim();
//		try {
//			int value = Integer.parseInt(text);
//			return value;
//		} catch (NumberFormatException e) {
//			return 0;
//		}
	}
	
	public static void main(String[] args) {
		System.out.println(NumberUtils.toInt(null));	// 0;
		System.out.println(NumberUtils.toInt(""));		// 0;
		System.out.println(NumberUtils.toInt("   "));	// 0;
		System.out.println(NumberUtils.toInt("각 "));	// 0;
		System.out.println(NumberUtils.toInt("123 "));	// 123;
		System.out.println(NumberUtils.toInt("123"));	// 123;
		
		System.out.println();
		
		System.out.println(NumberUtils.toInt(null, 1));		// 1;
		System.out.println(NumberUtils.toInt("", 1));		// 1;
		System.out.println(NumberUtils.toInt("   ", 1));	// 1;
		System.out.println(NumberUtils.toInt("각 ", 1));		// 1;
		System.out.println(NumberUtils.toInt("123 ", 1));	// 123;
		System.out.println(NumberUtils.toInt("123", 1));	// 123;
	}
}