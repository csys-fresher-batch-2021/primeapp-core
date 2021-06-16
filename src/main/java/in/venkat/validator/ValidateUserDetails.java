package in.venkat.validator;

import java.util.List;

import in.venkat.dao.UserDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.exceptions.InvalidNumberException;
import in.venkat.exceptions.InvalidPasswordException;
import in.venkat.exceptions.InvalidPhoneNumberException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.exceptions.PasswordMismatchException;
import in.venkat.model.User;
import in.venkat.util.MobileNumberValidationUtil;
import in.venkat.util.NameValidationUtil;
import in.venkat.util.PasswordValidationUtil;

public class ValidateUserDetails {
	private ValidateUserDetails() {
		/**
		 * adding private constructor
		 */
	}

	/**
	 * This method is used to validate the user registration details
	 * 
	 * @param name
	 * @param mobileNumber
	 * @param userPasscode
	 * @param reEnteredPasscode
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidNameException
	 * @throws InvalidNumberException
	 * @throws InvalidPasswordException
	 * @throws PasswordMismatchException
	 */
	public static boolean validateUserDetails(String name, long mobileNumber, String userPasscode)
			throws EmptyFieldException, InvalidNameException, InvalidNumberException, InvalidPasswordException {
		boolean isAllValid = false;
		boolean isNameValid = NameValidationUtil.validateName(name);
		boolean isMobileNumValid = MobileNumberValidationUtil.validateMobileNumber(mobileNumber);
		boolean isUserPasscodeValid = PasswordValidationUtil.validatePassword(userPasscode);
		if (isNameValid && isMobileNumValid && isUserPasscodeValid) {
			isAllValid = true;

		}
		return isAllValid;
	}

	/**
	 * This method is used to check whether password and re-entered password are
	 * same
	 * 
	 * @param userPasscode
	 * @param reEnteredPasscode
	 * @return
	 * @throws PasswordMismatchException
	 */
	public static boolean isPassEqual(String userPasscode, String reEnteredPasscode) throws PasswordMismatchException {
		boolean isPassEqual = false;
		if (userPasscode.trim().equals(reEnteredPasscode.trim())) {
			isPassEqual = true;

		} else {
			throw new PasswordMismatchException("the re-entered password is not matching");
		}
		return isPassEqual;

	}

	/**
	 * This method checks the phone number and parse it
	 * 
	 * @param userId
	 * @return
	 * @throws InvalidPhoneNumberException
	 */
	public static long checkPhoneNumber(String userId) throws InvalidPhoneNumberException {

		try {
			return Long.parseLong(userId);
		} catch (Exception e) {
			throw new InvalidPhoneNumberException("phone number is inValid");
		}

	}

	/**
	 * This method is used to check whether the user is registered user
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 * @throws InvalidUserIdException
	 */
	public static boolean checkUserId(String userId) throws DbException, InvalidUserIdException {
		boolean isExist = false;
		List<User> userIdList = UserDao.getAllRegisteredUserId();
		for (User primeTopup : userIdList) {
			if (primeTopup.getUserId().equals(userId)) {
				isExist = true;

				break;
			}

		}
		if (!isExist) {
			throw new InvalidUserIdException("user Id is invalid");
		}

		return isExist;
	}

}
