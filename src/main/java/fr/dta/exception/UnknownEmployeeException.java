package fr.dta.exception;

public class UnknownEmployeeException extends RuntimeException {

	private static final long serialVersionUID = -1502008288072468347L;

	public UnknownEmployeeException(String message) {
		super(message);
	}

}
