package in.venkat.service;

import java.sql.SQLException;

import in.venkat.dao.UserRegistrationDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.exceptions.InvalidNumberException;
import in.venkat.exceptions.InvalidPasswordException;
import in.venkat.exceptions.PasswordMismatchException;
import in.venkat.model.UserRegistration;
import in.venkat.validator.ValidateUserDetails;

public class UserRegistrationService {
	private UserRegistrationService() {
		/**
		 * adding a private constructor
		 */
	}

	/**
	 * 
	 * @param name
	 * @param mobileNumber
	 * @param userPasscode
	 * @param reEnteredPasscode
	 * @return
	 * @throws EmptyFieldException       when any field is empty it throws
	 *                                   EmptyFieldException
	 * @throws InvalidNameException      when the name contains any numbers then it
	 *                                   throws InvalidNameException
	 * @throws InvalidNumberException    when the mobile number contains any
	 *                                   alphabets then it throws
	 *                                   InvalidNumberException
	 * @throws InvalidPasswordException  when the password is in less security level
	 *                                   then it throws InvalidPasswordException
	 * @throws PasswordMismatchException when the password and re-entered password
	 *                                   is incorrect then it throws
	 *                                   PasswordMismatchException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DbException
	 */
	public static boolean registerUser(String name, long mobileNumber, String userPasscode, String reEnteredPasscode)
			throws EmptyFieldException, InvalidNameException, InvalidNumberException, InvalidPasswordException,
			PasswordMismatchException, SQLException, DbException {

		boolean isValid = ValidateUserDetails.validateUserDetails(name, mobileNumber, userPasscode, reEnteredPasscode);
		if (isValid) {
			String mobNum = Long.toString(mobileNumber);
			String userId = name.concat(mobNum);
			UserRegistration register = new UserRegistration(userId, name, mobileNumber, userPasscode);
			UserRegistrationDao.register(register);

		}
		return isValid;

	}
}
