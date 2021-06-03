package in.venkat.util;

import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidMovieIdException;

public class IdValidationUtil {
	/**
	 * This method validates the id 
	 * 
	 * @param id
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidMovieIdException
	 */
	public static boolean validateName(String id) throws EmptyFieldException, InvalidMovieIdException {
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
		String regex = "^[0-9]{1}$";
		if (id.matches(regex)) {

			valid = true;
		} else {
			throw new InvalidMovieIdException("invalidMovieId");
		}
		return valid;

	}

}
