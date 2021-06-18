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
	public static boolean validateId(int id) throws EmptyFieldException, InvalidMovieIdException {
		boolean isValid = false;
		String movieId = Integer.toString(id);
		if (!movieId.trim().isEmpty()) {
			isValid = checkId(movieId);
		} else {
			throw new EmptyFieldException("empty field");
		}

		return isValid;
	}

	private static boolean checkId(String id) throws InvalidMovieIdException {
		boolean valid = false;
		String regex = "^[0-9]+$";
		if (id.matches(regex)) {
			valid = true;

		} else {
			throw new InvalidMovieIdException("invalidMovieId");
		}
		return valid;

	}

}
