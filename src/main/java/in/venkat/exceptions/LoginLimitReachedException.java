package in.venkat.exceptions;

public class LoginLimitReachedException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginLimitReachedException(String message) {
		super(message);
	}
}
