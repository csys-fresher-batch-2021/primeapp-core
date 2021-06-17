package in.venkat.util;

import in.venkat.exceptions.InvalidDetailsException;

public class ShowDetailsValidationUtil {
	private ShowDetailsValidationUtil() {
		/**
		 * Adding a private constructor
		 */
	}

	/**
	 * This method is used to validate year
	 * 
	 * @param year
	 * @return
	 * @throws InvalidDetailsException
	 */
	public static boolean isYearValid(int year) throws InvalidDetailsException {
		boolean valid = false;
		if (year > 1950 && year <= 2021) {
			valid = true;

		} else {
			throw new InvalidDetailsException("invalid year");
		}
		return valid;
	}

	/**
	 * This method is used to validate the category
	 * 
	 * @param category
	 * @return
	 * @throws InvalidDetailsException
	 */
	public static boolean validateMembership(String category) throws InvalidDetailsException {
		boolean valid = false;
		if (category.trim().equalsIgnoreCase("prime") || category.trim().equalsIgnoreCase("non prime")) {
			valid = true;
		} else {
			throw new InvalidDetailsException("invalid membership");
		}

		return valid;
	}

	/**
	 * This method is used to validate the grade
	 * 
	 * @param grade
	 * @return
	 * @throws InvalidDetailsException
	 */
	public static boolean gradeValidation(String grade) throws InvalidDetailsException {
		boolean valid = false;
		if (grade.trim().equals("U") || grade.trim().equals("V") || grade.trim().equals("A")) {
			valid = true;
		} else {
			throw new InvalidDetailsException("invalid grade ! grade should be ('A','V','U')");
		}
		return valid;
	}

	/**
	 * This method is used to valid the status
	 * 
	 * @param status
	 * @return
	 * @throws InvalidDetailsException
	 */
	public static boolean statusValidation(String status) throws InvalidDetailsException {
		boolean valid = false;
		if (status.trim().equals("active") || status.trim().equalsIgnoreCase("inactive")) {
			valid = true;
		} else {
			throw new InvalidDetailsException("status  should be ('active','inactive')");
		}

		return valid;
	}

}
