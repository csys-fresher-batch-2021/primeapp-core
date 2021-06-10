package in.venkat.exceptions;

public class UserIdPasswordMismatchException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserIdPasswordMismatchException(String message) {
		super(message);
	}
}
