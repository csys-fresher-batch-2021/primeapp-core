package in.venkat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidPasswordException;

public class PasswordValidationUtil {
	private PasswordValidationUtil() {
		/**
		 * Adding private constructor
		 */
	}

	/**
	 * This method validates the password
	 * 
	 * @param userPassword
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidPasswordException
	 */
	public static boolean validatePassword(String userPassword) throws EmptyFieldException, InvalidPasswordException {
		boolean isValid = false;
		if (!userPassword.trim().isEmpty()) {
			isValid = checkPassword(userPassword);
		} else {
			throw new EmptyFieldException("Empty field");
		}
		return isValid;
	}

	private static boolean checkPassword(String userPassword) throws InvalidPasswordException {
		boolean valid = false;
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{5,}$";
		if (!userPassword.isEmpty()) {
			Pattern pattern = Pattern.compile(regex);
			Matcher match = pattern.matcher(userPassword);

			valid = match.matches();
		} else {

			throw new InvalidPasswordException("password has low security level");
		}
		return valid;

	}

}