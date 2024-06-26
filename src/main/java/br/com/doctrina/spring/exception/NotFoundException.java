package br.com.doctrina.spring.exception;

public class NotFoundException extends ApplicationException{

	private static final long serialVersionUID = 6896739962555882487L;
	
	public NotFoundException(String message) {
		super(message);
	}

}
