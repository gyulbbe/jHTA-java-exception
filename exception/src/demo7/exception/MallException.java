package demo7.exception;

public class MallException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8498582647348827350L;
	
	public MallException() {}
	public MallException(String message) {
		super(message);
	}	
}
