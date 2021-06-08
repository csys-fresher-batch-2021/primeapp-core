package in.venkat.util;

import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidNumberException;

public class MobileNumberValidationUtil {
	/**
	 * This method validates the mobile number
	 * 
	 * @param mobNo
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidNumberException
	 */
	public static boolean validateMobileNumber(long mobNo) throws EmptyFieldException, InvalidNumberException {
		boolean isValid = false;
		String mobileNumber = Long.toString(mobNo);
		if (!mobileNumber.trim().isEmpty()) {
			isValid = checkNumber(mobileNumber);
		} else {
			throw new EmptyFieldException("empty field");
		}

		return isValid;
	}

	public static boolean checkNumber(String mobileNumber) throws InvalidNumberException {
		boolean valid = false;
		String regex = "^[0-9]{10}$";
		if (mobileNumber.matches(regex) && mobileNumber.length() == 10) {
			valid = true;
		} else {
			throw new InvalidNumberException("Invalid Number");
		}
		return valid;

	}

}
