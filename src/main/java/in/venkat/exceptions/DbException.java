package in.venkat.exceptions;

public class DbException extends Exception {

	private static final long serialVersionUID = 1L;

	public DbException(String message) {
		super(message);
	}

	public DbException(Exception e, String message) {
		super(message, e);
	}
}
