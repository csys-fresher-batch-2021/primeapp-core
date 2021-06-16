package in.venkat.exceptions;

public class PlanNotExpiredException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlanNotExpiredException(String message) {
		super(message);
	}

}