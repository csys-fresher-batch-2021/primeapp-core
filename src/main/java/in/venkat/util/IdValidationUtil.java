package in.venkat.util;

import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidMovieIdException;

public class IdValidationUtil {
	private IdValidationUtil() {
		/**
		 * Adding a private constructor
		 */
	}

	/**
	 * This method validates the id
	 * 
	 * @param id
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidMovieIdException
	 */
	public static boolean validateId(String id) throws EmptyFieldException, InvalidMovieIdException {
		boolean isValid = false;
		if (!id.trim().isEmpty()) {
			isValid = checkId(id);
		} else {
			throw new EmptyFieldException("empty field");
		}

		return isValid;
	}

	private static boolean checkId(String id) throws InvalidMovieIdException {
		boolean valid = false;
		String regex = "^[1-9]{0,150}$";
		if (id.matches(regex)) {

			valid = true;
		} else {
			throw new InvalidMovieIdException("invalidMovieId");
		}
		return valid;

	}

}
