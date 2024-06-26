package br.com.doctrina.spring.exception;

public class BusinessException extends ApplicationException{

	private static final long serialVersionUID = -8598157078583645828L;

	public BusinessException(String message) {
		super(message);
	}
}
