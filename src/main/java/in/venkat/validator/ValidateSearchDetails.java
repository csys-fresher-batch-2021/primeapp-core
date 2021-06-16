package in.venkat.validator;

import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.util.NameValidationUtil;

public class ValidateSearchDetails {
	private ValidateSearchDetails() {
		/**
		 * Adding private constructor
		 */
	}

	/**
	 * This method validates the film genre and language
	 * 
	 * @param filmGenre
	 * @param filmLanguage
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidNameException
	 * @throws InvalidDetailsException
	 */
	public static boolean validateDetails(String filmGenre, String filmLanguage)
			throws EmptyFieldException, InvalidNameException, InvalidDetailsException {
		boolean valid = false;
		if (NameValidationUtil.validateName(filmGenre) && NameValidationUtil.validateName(filmLanguage)) {
			valid = true;

		} else {
			throw new InvalidDetailsException("inValid details");
		}
		return valid;
	}

	/**
	 * This method validates the film language and check
	 * 
	 * @param filmLanguage
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidNameException
	 * @throws InvalidDetailsException
	 */
	public static boolean validateDetails(String filmLanguage)
			throws EmptyFieldException, InvalidNameException, InvalidDetailsException {
		boolean valid = false;
		if (NameValidationUtil.validateName(filmLanguage)) {
			valid = true;

		} else {
			throw new InvalidDetailsException("inValid details");
		}
		return valid;
	}

}
