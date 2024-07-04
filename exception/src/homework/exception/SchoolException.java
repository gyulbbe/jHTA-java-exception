package homework.exception;

public class SchoolException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8279259484159780723L;
	
	public SchoolException () {}
	public SchoolException (String message) {
		super(message);
	}
}
