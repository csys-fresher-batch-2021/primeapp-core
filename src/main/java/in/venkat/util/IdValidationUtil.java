package in.venkat.util;

import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidMovieIdException;

public class IdValidationUtil {
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
		String regex = "[a-zA-Z0-9]+\\.?";
		if (id.matches(regex) && id.length() <= 3) {

			valid = true;
		}
		else {
			throw new InvalidMovieIdException("invalidMovieId");
		}
		return valid;
		

	}

}
