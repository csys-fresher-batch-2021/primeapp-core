package in.venkat.exceptions;

public class InvalidUserIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserIdException(String message) {
		super(message);
	}
}