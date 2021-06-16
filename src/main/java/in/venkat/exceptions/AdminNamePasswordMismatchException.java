package in.venkat.exceptions;

public class AdminNamePasswordMismatchException extends Exception {

	private static final long serialVersionUID = 1L;

	public AdminNamePasswordMismatchException(String message) {
		super(message);
	}
}
