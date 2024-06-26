package br.com.doctrina.spring.exception;

public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = -3681765236771816148L;

	public ApplicationException() {
		super();
	}
	
	public ApplicationException(String message, Exception e) {
		super(message, e);
	}
	
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(Exception e) {
		super(e);
	}
}
