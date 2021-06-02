package in.venkat.exceptions;

public class InvalidMovieIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidMovieIdException(String message) {
		super(message);
	}
}
