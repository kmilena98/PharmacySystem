package exceptions;

public class ValidationExeption extends Exception {
	public ValidationExeption(String errorMessage,Throwable error) {
		super(errorMessage,error);
	}
}
