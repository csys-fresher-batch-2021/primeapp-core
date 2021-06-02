package in.venkat.validator;

import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.util.NameValidationUtil;

public class validateSearchDetails {

	public static boolean validateDetails(String flimGenre, String flimLanguage)
			throws EmptyFieldException, InvalidNameException, InvalidDetailsException {
		boolean valid = false;
		if (NameValidationUtil.validateName(flimGenre) && NameValidationUtil.validateName(flimLanguage)) {
			valid = true;

		} else {
			throw new InvalidDetailsException("inValid details");
		}
		return valid;
	}

	public static boolean validateDetails(String flimLanguage)throws EmptyFieldException, InvalidNameException, InvalidDetailsException {
		boolean valid = false;
		if ( NameValidationUtil.validateName(flimLanguage)) {
			valid = true;

		} else {
			throw new InvalidDetailsException("inValid details");
		}
		return valid;
	}

}
