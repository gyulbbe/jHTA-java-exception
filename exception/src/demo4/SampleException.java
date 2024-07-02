package demo4;

/*
 * 사용자정의 예외 클래스
 * 	사용자정의 예외클래스는 Exception 혹은 RuntimeException을 상속받아서 정의한다.
 * 	사용자정의 예외클래스는 오류메시지와 오류 객체를 초기화하는 생성자 메소드만 정의하면 된다.
 * 	사용자정의 예외클래스에서 오류메시지와 오류정보는 Throwable 클래스에 멤버변수로 저장되기 때문에, 부모의 생성자 메소드를 호출해서 값을 저장해야 된다.
 */
public class SampleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3476578579476789961L;

	public SampleException() {
		
	}
	
	public SampleException(String message) {
		super(message);
	}
	
	public SampleException(Throwable cause) {
		super(cause);
	}
	
	public SampleException(String message, Throwable cause) {
		super(message, cause);
	}
}